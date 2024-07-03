package com.example.vit_appdevelopment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{

    var dataArray = arrayOf("india","hindi","australia","blue")
    var TAG = HomeActivity::class.java.simpleName

    lateinit var mySpinner: Spinner
//    lateinit var myListView: ListView
    lateinit var myRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        mySpinner = findViewById(R.id.spinner)
//        myListView = findViewById(R.id.listView)
//        myListView.isClickable = true
        myRecycler = findViewById(R.id.recyclerView)

        myRecycler.layoutManager = LinearLayoutManager(this)
//            GridLayoutManager(this, 2) - in rows

        var wordsAdapter = WordsAdapter(dataArray)
        myRecycler.adapter = wordsAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mySpinner.onItemSelectedListener = this
//        myListView.setOnItemClickListener(this)

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

    fun getShowText(view: View) {
        var etUi:EditText = findViewById(R.id.etUITest)
        var text = etUi.text.toString()
        var tvUi: TextView = findViewById(R.id.tvUI)
        tvUi.setText(text)
    }

//    override fun onItemClick(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        var item:String = adapter?.getItemAtPosition(position).toString()
//        Log.i(TAG, item)
//    }

//    suspend itself -- resume
    fun downloadImage(): String{
        return "image"
    }

// url for getting weather data
    fun getWeather(cityName:String):String{
        return "{ temp:32, windspeed:40 }"
    }
    fun getTemp(city:String):Int{
        return 25
    }

}