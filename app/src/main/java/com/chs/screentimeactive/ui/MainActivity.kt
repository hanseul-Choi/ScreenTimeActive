package com.chs.screentimeactive.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.chs.screentimeactive.R
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

        if(PermissionUtil.checkPermission(this)) {
            
        }
    }
}