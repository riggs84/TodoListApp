package com.example.todolistapp.di

import android.app.Application
import androidx.room.Room
import com.example.todolistapp.data.database.TodoDataBase
import com.example.todolistapp.data.database.dao.TodoDao
import com.example.todolistapp.data.repository.TodoRepository
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
    fun provideTodoDataBase(app: Application): TodoDataBase {
        return Room.databaseBuilder(
            app,
            TodoDataBase::class.java,
            "todoDatabase"
        ).allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideDataBaseDao(db: TodoDataBase): TodoDao {
        return db.todoDao()
    }

    @Provides
    @Singleton
    fun provideRepository(todoDao: TodoDao): TodoRepository {
        return TodoRepository(todoDao)
    }
}