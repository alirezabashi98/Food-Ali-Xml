package com.alirezabashi98.foodalixml.model

import android.text.Editable

data class FoodModel(
    val name: String,
    val imageUrl: String,
    val location: String,
    val star: Float,
    val renegeStart: Int,
    val Price: String,
    val arrivingTime: String
)
