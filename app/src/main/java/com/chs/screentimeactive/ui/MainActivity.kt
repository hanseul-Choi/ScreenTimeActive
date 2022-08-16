package com.chs.screentimeactive.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.chs.screentimeactive.R
import com.chs.screentimeactive.common.CommonUtil
import com.chs.screentimeactive.permission.PermissionUtil
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.menu_bnv)

        val navController = supportFragmentManager.findFragmentById(R.id.container_fcv)?.findNavController()

        navController?.let {
            bottomNavigationView.setupWithNavController(it)
        }

        if(!PermissionUtil.checkOPSPermission(this)) {
            PermissionUtil.checkFirstPermission = false
            PermissionUtil.showPermissionDialog(this)
        }
    }

    override fun onResume() {
        super.onResume()

        // 앱 실행 초기에 권한을 허용하지 않은 경우
        if(PermissionUtil.checkFirstPermission && !PermissionUtil.checkOPSPermission(this)) {
            Log.e("permission", "PACKAGE_USAGE_STATS Permission is denied!")
            CommonUtil.exitApp(this)
        }
    }
}