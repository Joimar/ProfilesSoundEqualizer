package com.example.profilessoundequalizer
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AudioSettingsSavedDao {
    @Query("SELECT * FROM audio_settings_saved")
    fun getAll(): List<AudioSettingsSaved>

    @Query("SELECT * FROM audio_settings_saved WHERE user_id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<AudioSettingsSaved>

    @Query("SELECT * FROM audio_settings_saved WHERE user_id LIKE :first AND " +
            "eq_1 LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): AudioSettingsSaved

    @Insert
    fun insertAll(vararg users: AudioSettingsSaved)

    @Delete
    fun delete(user: AudioSettingsSaved)
}

