package com.example.vit_appdevelopment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.vit_appdevelopment.database.Item
import com.example.vit_appdevelopment.database.ItemDao
import com.example.vit_appdevelopment.database.ItemRoomDatabase
import com.example.vit_appdevelopment.databinding.ActivityHomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity(){

    var TAG = HomeActivity::class.java.simpleName
    private lateinit var binding: ActivityHomeBinding
    lateinit var dao: ItemDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var  database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()

        binding.btnDbInsert.setOnClickListener{
            insertDataDb()
        }

    }
    private fun insertDataDb() {
        GlobalScope.launch {
            var item = Item(21,"fruits",11.11,11)
            dao.insert(item)
        }
    }

}