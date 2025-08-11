package com.shenawynkov.bm_days.data.models

import com.google.gson.annotations.SerializedName

data class Photo(
    val id: Int,
    val title: String,
    val url: String,
    @SerializedName("thumbnailUrl")
    val thumbUrl: String,
    )
