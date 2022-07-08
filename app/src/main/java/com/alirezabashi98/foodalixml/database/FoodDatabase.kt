package com.alirezabashi98.foodalixml.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alirezabashi98.foodalixml.database.Dao.FoodDao
import com.alirezabashi98.foodalixml.model.FoodModel

@Database(entities = [FoodModel::class], version = 1, exportSchema = false)
abstract class FoodDatabase : RoomDatabase() {

    abstract fun foodDao(): FoodDao

    companion object {
        private var database: FoodDatabase? = null
        fun getDatabase(context: Context): FoodDatabase {
            if (database == null) {
                database = Room.databaseBuilder(
                    context.applicationContext,
                    FoodDatabase::class.java,
                    "food.db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return database!!
        }
    }

}