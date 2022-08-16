package com.chs.screentimeactive.permission

import android.Manifest
import android.app.AlertDialog
import android.app.AppOpsManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import com.chs.screentimeactive.databinding.PermissionDialogBinding

object PermissionUtil {
    private lateinit var alertDialog: AlertDialog
    private val useAgeIntent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)

    var checkFirstPermission = false

    fun checkOPSPermission(context: Context) : Boolean {
        val appOps = context.applicationContext.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

        val mode = if(Build.VERSION_CODES.Q <= Build.VERSION.SDK_INT) {
            appOps.unsafeCheckOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,
                android.os.Process.myUid(), context.applicationContext.packageName)
        } else {
            appOps.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,
                android.os.Process.myUid(), context.applicationContext.packageName)
        }

        return if(mode == AppOpsManager.MODE_DEFAULT) {
            (context.applicationContext.checkCallingOrSelfPermission(
                Manifest.permission.PACKAGE_USAGE_STATS) == PackageManager.PERMISSION_GRANTED)
        } else {
            (mode == AppOpsManager.MODE_ALLOWED)
        }
    }

    fun showPermissionDialog(context: Context) {
//        val dialogView = (context as AppCompatActivity).layoutInflater.inflate(R.layout.permission_dialog, null)
        val dialogBindingView = PermissionDialogBinding.inflate(LayoutInflater.from(context), null, false)

        dialogBindingView.requirePermissionRv.adapter = PermissionAdapter()

        alertDialog = AlertDialog.Builder(context).setView(dialogBindingView.root)
            .setCancelable(false)
            .create()

        dialogBindingView.permissionApplyTv.setOnClickListener {
            Log.d("test", "click permission apply")
            checkFirstPermission = true

            context.startActivity(useAgeIntent)

            // dismiss dialog
            alertDialog.dismiss()
        }

        // show dialog
        alertDialog.show()
    }
}