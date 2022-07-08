package com.alirezabashi98.foodalixml.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_food")
data class FoodModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val imageUrl: String,
    val location: String,
    val star: Float,
    val renegeStart: Int,
    val Price: String,
    val arrivingTime: String
)
