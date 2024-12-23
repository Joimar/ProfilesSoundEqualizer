package com.example.profilessoundequalizer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey


@Entity(tableName = "audio_settings_saved", foreignKeys = [ForeignKey(
    entity = User::class,
    childColumns = ["user_id"], // Change Userid to parentId
    parentColumns = ["uid"],
    onDelete = CASCADE
)])
data class AudioSettingsSaved (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "user_id")
    var userId: Int? = null,
    @ColumnInfo(name = "eq_1")
    var eq1: Int? = null,

    @ColumnInfo(name = "eq_2")
    var eq2: Int? = null,

    @ColumnInfo(name = "eq_3")
    var eq3: Int? = null,

    @ColumnInfo(name = "eq_4")
    var eq4: Int? = null,

    @ColumnInfo(name = "eq_5")
    var eq5: Int? = null,

)