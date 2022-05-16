package com.alirezabashi98.foodalixml

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.alirezabashi98.foodalixml.adapter.FoodAdapter
import com.alirezabashi98.foodalixml.databinding.ActivityMainBinding
import com.alirezabashi98.foodalixml.databinding.LayoutAddFoodBinding
import com.alirezabashi98.foodalixml.model.FoodModel
import com.alirezabashi98.foodalixml.utility.getAllFood

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cast()
        addFood()
        setAdapter()

    }

    private fun addFood() {
        binding.addFood.setOnClickListener {
            val dialog = AlertDialog.Builder(this).create()
            val layoutAddFood = LayoutAddFoodBinding.inflate(layoutInflater)
            dialog.setView(layoutAddFood.root)
            dialog.create()
            dialog.show()

            layoutAddFood.doneAddFood.setOnClickListener {
                if (
                    layoutAddFood.foodName.text!!.isNotBlank() &&
                    layoutAddFood.foodCity.text!!.isNotBlank() &&
                    layoutAddFood.foodPrice.text!!.isNotBlank() &&
                    layoutAddFood.foodCity.text!!.isNotBlank()
                ) {
                    val random = (0..getAllFood().size).random()
                    val newFood = FoodModel(
                        name = layoutAddFood.foodName.text.toString(),
                        imageUrl = getAllFood()[random].imageUrl,
                        location = layoutAddFood.foodCity.text.toString(),
                        star = (0..5).random().toFloat(),
                        renegeStart = (0..200).random(),
                        Price = layoutAddFood.foodPrice.text.toString(),
                        arrivingTime = "${(0..5).random()}h${(1..50).random()}m"
                    )
                    myAdapter.addFood(newFood)
                    binding.recyclerListFood.scrollToPosition(0)
                    dialog.dismiss()
                } else {
                    Toast.makeText(this, "لطفا همه مقادیر را پرکنید", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun cast() {
        myAdapter = FoodAdapter(getAllFood().clone() as ArrayList<FoodModel>)
    }

    private fun setAdapter() {
        binding.recyclerListFood.layoutManager = LinearLayoutManager(this)
        binding.recyclerListFood.adapter = myAdapter
    }

}