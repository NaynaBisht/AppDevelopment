package com.example.vit_appdevelopment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun clickHandler(view: View) {
        Log.i("MainActivity-clickHandler", "button clicked")
//        intent = intention
        var dialIntent: Intent = Intent(Intent.ACTION_DIAL)
       startActivity(dialIntent)
//        var dialIntent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:98765432"))

        var webIntent: Intent = Intent(Intent.ACTION_VIEW,Uri.parse("http://www.ndtv.com"))
        startActivity(webIntent)
    }
}
