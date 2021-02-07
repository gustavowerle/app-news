package com.gw.appnews.ui

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.gw.appnews.R
import dagger.hilt.android.AndroidEntryPoint
import java.util.jar.Manifest

@AndroidEntryPoint
class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        requestPermissions()
    }

    private fun requestPermissions() {
            val permission = ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.INTERNET)

            if (permission != PackageManager.PERMISSION_GRANTED) {
                Log.i("PERMISSOES", "Permission to record denied")
            } else {
                Log.i("PERMISSOES", "Permission allowed")
            }
    }
}