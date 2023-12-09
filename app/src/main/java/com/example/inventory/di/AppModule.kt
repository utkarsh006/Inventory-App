package com.example.inventory.di

import android.app.Application
import androidx.room.Room
import com.example.inventory.data.database.ItemDB
import com.example.inventory.data.repository.ItemRepositoryImpl
import com.example.inventory.domain.repository.ItemRepository
import com.example.inventory.domain.usecases.DeleteItem
import com.example.inventory.domain.usecases.ItemUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): ItemDB {
        return Room.databaseBuilder(
            app,
            ItemDB::class.java,
            ItemDB.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: ItemDB): ItemRepository {
        return ItemRepositoryImpl(db.itemDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: ItemRepository): ItemUseCases {
        return ItemUseCases(
            deleteItem = DeleteItem(repository)
        )
    }

}