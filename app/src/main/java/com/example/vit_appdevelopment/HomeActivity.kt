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

class HomeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener,
    AdapterView.OnItemClickListener {

    var TAG = HomeActivity::class.java.simpleName

    lateinit var mySpinner: Spinner
    lateinit var myListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        mySpinner = findViewById(R.id.spinner)
        myListView = findViewById(R.id.listView)
        myListView.isClickable = true


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mySpinner.onItemSelectedListener = this
        myListView.setOnItemClickListener(this)

//        var data = intent.extras?.getString("nkey")
//        Log.i("HomeActivity", "data is ="+data)
//        val homeTextView: TextView = findViewById(R.id.textViewHome)
//        homeTextView.setText(data)
    }

    override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item:String = adapter?.getItemAtPosition(position).toString()
        Log.i(TAG, item)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item:String = adapter?.getItemAtPosition(position).toString()
        Log.i(TAG, item)
    }
}