package com.example.hiltmvvmdemo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hiltmvvmdemo.database.AlertDao
import com.example.hiltmvvmdemo.models.Alert

@Database(entities = [Alert::class], version = 1, exportSchema = false)
abstract class AlertDatabase : RoomDatabase(){
    abstract fun userDao(): AlertDao

}