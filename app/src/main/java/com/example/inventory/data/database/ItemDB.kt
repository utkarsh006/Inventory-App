package com.example.inventory.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.inventory.data.dataClasses.Item
import com.example.inventory.data.database.ItemDao


@Database(
    entities = [Item::class],
    version = 1
)

abstract class ItemDB : RoomDatabase() {
    abstract val itemDao: ItemDao

    companion object {
        const val DB_NAME = "item_db"
    }
}