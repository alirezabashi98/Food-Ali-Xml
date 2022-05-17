package com.alirezabashi98.foodalixml.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alirezabashi98.foodalixml.databinding.ItemFoodBinding
import com.alirezabashi98.foodalixml.model.FoodModel
import com.alirezabashi98.foodalixml.utility.glideSetImage

class FoodAdapter(var data: ArrayList<FoodModel>, val onTab: onTabItem) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    class ViewHolder(private val item: ItemFoodBinding) : RecyclerView.ViewHolder(item.root) {
        @SuppressLint("SetTextI18n")
        fun setData(food: FoodModel, onTab: onTabItem, position: Int) {
            item.root.setOnClickListener { onTab.onClick(food, position) }
            item.root.setOnLongClickListener { onTab.onLongClick(food, position); true }
            item.nameFood.text = food.name
            item.renegeStartFood.text = "${food.renegeStart} people comment"
            item.locationFood.text = food.location
            item.priceFood.text = food.Price
            item.arrivingTimeFood.text = food.arrivingTime
            item.startFood.rating = food.star
            item.root.context.glideSetImage(url = food.imageUrl, view = item.imageFood)
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
        holder.setData(data[position], onTab, position)

    override fun getItemCount(): Int = data.size

    fun addFood(food: FoodModel) {
        data.add(0, food)
        notifyItemChanged(0)
    }

    fun upDateFood(food: FoodModel, position: Int) {
        data.set(position,food)
        notifyItemChanged(position)
    }

    fun removeFood(food: FoodModel,position: Int){
        data.remove(food)
        notifyItemRemoved(position)
    }

}

interface onTabItem {

    fun onClick(food: FoodModel, position: Int)

    fun onLongClick(food: FoodModel,position: Int)

}