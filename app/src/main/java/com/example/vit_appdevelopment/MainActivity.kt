package com.example.vit_appdevelopment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
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
        /*var dialIntent: Intent = Intent(Intent.ACTION_DIAL)
       startActivity(dialIntent)*/
//        var dialIntent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:98765432"))

//        var webIntent: Intent = Intent(Intent.ACTION_VIEW,Uri.parse("http://www.ndtv.com"))
//        startActivity(webIntent)

//        createAlarm("vit", 9, 21)

        val hIntent = Intent(this, HomeActivity::class.java)
        startActivity(hIntent)


    }

    fun createAlarm(message:String, hour:Int, minutes:Int){
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply{
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES,minutes)
        }
        startActivity(intent)
    }
}
