package com.alirezabashi98.foodalixml

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.alirezabashi98.foodalixml.adapter.FoodAdapter
import com.alirezabashi98.foodalixml.databinding.ActivityMainBinding
import com.alirezabashi98.foodalixml.model.FoodModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFood()
        setAdapter()

    }

    private fun addFood() {
        binding.addFood.setOnClickListener {
            Toast.makeText(applicationContext, "Add Food", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAdapter() {
        binding.recyclerListFood.layoutManager = LinearLayoutManager(this)
        binding.recyclerListFood.adapter = FoodAdapter(
            listOf(
                FoodModel(
                    name = "hzkdl",
                    imageUrl = "https://cdn.yjc.news/files/fa/news/1399/1/24/11699239_543.jpg",
                    location = "fghstf",
                    star = 3.5f,
                    renegeStart = 78,
                    Price = 78,
                    arrivingTime = "dfh"
                )
            )
        )
    }
}