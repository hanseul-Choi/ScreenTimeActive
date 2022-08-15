package com.chs.screentimeactive.permission

import android.Manifest
import android.app.AlertDialog
import android.app.AppOpsManager
import android.app.Dialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import com.chs.screentimeactive.R

object PermissionUtil {
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
        val dialogView = (context as AppCompatActivity).layoutInflater.inflate(R.layout.activity_main, null)

        AlertDialog.Builder(context)
            .setView(dialogView)
            .create()
            .show()
    }
}