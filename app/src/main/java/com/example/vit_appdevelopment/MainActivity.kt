package com.example.vit_appdevelopment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.i(TAG, "activity is getting created")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

//    activity is visible to user
    override fun onStart() {
        super.onStart()
        Log.e(TAG, "activity is started")
    }

//    activity has paused
    override fun onPause() {
        super.onPause()
    Log.w(TAG, "activity is paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "activity is getting stopped")
    }
//    activity no longer exists
    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "activity is destroyed")
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
        hIntent.putExtra("nkey", "android")
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


    fun inflateXml(){
        var nameEditText = EditText(this)
        nameEditText.setHint("enter your name")
        var pwdEditText = EditText(this)
        pwdEditText.setHint("enter your pass")
        var loginButton = Button(this)
        loginButton.setText("login")
    }


}
