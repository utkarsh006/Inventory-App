package com.example.inventory.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.inventory.data.dataClasses.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM item")
    fun getItems(): Flow<List<Item>>

    @Query("SELECT * FROM item WHERE id = :id")
    suspend fun getItemById(id: Int): Item?

    //if we call INSERT function with an existing id, it will update the existing entry
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)

}