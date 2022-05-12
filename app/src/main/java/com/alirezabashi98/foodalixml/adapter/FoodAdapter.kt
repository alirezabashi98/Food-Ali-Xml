package com.alirezabashi98.foodalixml.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alirezabashi98.foodalixml.databinding.ItemFoodBinding
import com.alirezabashi98.foodalixml.model.FoodModel

class FoodAdapter(var data: List<FoodModel>) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    class ViewHolder(private val item: ItemFoodBinding) : RecyclerView.ViewHolder(item.root) {
        fun setData(food: FoodModel) {
            item.nameFood.text = food.name
            item.renegeStartFood.text = food.renegeStart.toString()
            item.locationFood.text = food.location
            item.arrivingTimeFood.text = food.arrivingTime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.setData(data[position])

    override fun getItemCount(): Int = data.size

}