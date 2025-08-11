package com.shenawynkov.bm_days.data.DB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
    @PrimaryKey val id: Int,
    val body: String,
    val title: String,
    val userId: Int
)