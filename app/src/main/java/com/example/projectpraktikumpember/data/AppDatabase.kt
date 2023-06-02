package com.example.projectpraktikumpember.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projectpraktikumpember.data.dao.UserDao
import com.example.projectpraktikumpember.data.entity.User


@Database(entities = [User::class], version = 2)
abstract  class AppDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao

    companion object{
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            if (instance == null){
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "app-database")
                        // jika mengganti nama tabel data tidak eror
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }

            return  instance!!
        }
    }
}