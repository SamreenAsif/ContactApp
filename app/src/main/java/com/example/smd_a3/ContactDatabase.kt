package com.example.smd_a3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Contact::class],
    version = 1,
    exportSchema = false
)

abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao

    companion object {
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase {
            return INSTANCE ?: synchronized(this) {
                // create database
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "contact_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}