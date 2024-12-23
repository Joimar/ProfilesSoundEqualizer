package com.example.profilessoundequalizer

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class, AudioSettingsSaved::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun audioSettingsSaved(): AudioSettingsSavedDao
}