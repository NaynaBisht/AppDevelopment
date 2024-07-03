package com.example.vit_appdevelopment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.vit_appdevelopment.databinding.ActivityHomeBinding
import com.example.vit_appdevelopment.network.MarsApi
import com.example.vit_appdevelopment.network.MarsPhoto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeActivity : AppCompatActivity(){

    var TAG = HomeActivity::class.java.simpleName

    private lateinit var binding : ActivityHomeBinding
    val photoMarsDataBinding = MarsPhoto("007", "moon.com")

//    lateinit var marsRecyclerView: RecyclerView
    lateinit var marsAdapter: MarsAdapter
    lateinit var photos: List<MarsPhoto>
//    lateinit var imageView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_home)

        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.marsphotoxml = photoMarsDataBinding

//        imageView = findViewById(R.id.imageView)

//        marsRecyclerView = findViewById(R.id.recyclerViewUrls)/
        binding.recyclerViewUrls.layoutManager = LinearLayoutManager(this)
        photos = ArrayList()
        marsAdapter = MarsAdapter(photos)
        binding.recyclerViewUrls.adapter = marsAdapter
//        marsAdapter = MarsAdapter(photos)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    private fun getMarsPhotos() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val listMarsPhotos = MarsApi.retrofitService.getPhotos()

                withContext(Dispatchers.Main) {
                    photos = listMarsPhotos
                    marsAdapter = MarsAdapter(photos)
//                    marsRecyclerView.adapter = marsAdapter
                    marsAdapter.notifyDataSetChanged()
//                    binding.imageView.load()

                    Log.i("homeactivity", listMarsPhotos.size.toString())
                    Log.i("homeactivity - url", listMarsPhotos.get(1).imgSrc)
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching Mars photos", e)
            }
        }
    }

    fun getJson(view: View) {
        getMarsPhotos()
    }
}