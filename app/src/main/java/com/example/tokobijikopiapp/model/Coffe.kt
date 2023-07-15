package com.example.tokobijikopiapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "coffe_table")
data class Coffe (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val address: String,
    val latitude: Double?,
    val longtitude: Double?
    ) : Parcelable