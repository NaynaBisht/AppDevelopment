package com.example.vit_appdevelopment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vit_appdevelopment.network.MarsApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity(){

    var TAG = HomeActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    private fun getMarsPhotos() {
        GlobalScope.launch {
           var listMarsPhotos  = MarsApi.retrofitService.getPhotos()
//            var textViewHome:TextView = findViewById(R.id.textViewHome)
//            textViewHome.setText(listMarsPhotos.get(1).imgSrc)
            Log.i( "homeactivity ", listMarsPhotos.size.toString())
            Log.i( "homeactivity - url ", listMarsPhotos.get(1).imgSrc)

        }
    }

    fun getJson(view: View) {
        getMarsPhotos()
    }
}