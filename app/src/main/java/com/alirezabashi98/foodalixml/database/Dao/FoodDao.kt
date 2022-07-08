package com.alirezabashi98.foodalixml.database.Dao

import androidx.room.*
import com.alirezabashi98.foodalixml.model.FoodModel

@Dao
interface FoodDao {

    @Query("SELECT * FROM table_food")
    fun getAllFood(): List<FoodModel>

    @Query("SELECT * FROM table_food WHERE id = :id")
    fun getFoodById(id: Int): FoodModel

    @Query("SELECT * FROM table_food WHERE name LIKE '%' || :text || '%' ")
    fun searchFood(text: String): List<FoodModel>

    @Insert
    fun insertFood(food: FoodModel)

    @Insert
    fun insertListFood(listFood: List<FoodModel>)

    @Update
    fun updateFood(food: FoodModel)

    @Delete
    fun deleteFood(food: FoodModel)

    @Query("DELETE FROM table_food")
    fun deleteAllFood()
}