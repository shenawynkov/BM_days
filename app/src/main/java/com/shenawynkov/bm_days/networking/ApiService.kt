package com.shenawynkov.bm_days.networking

import com.shenawynkov.bm_days.data.Photo
import com.shenawynkov.bm_days.data.Post
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getPhotos(): List<Photo>
    @GET("posts")
    suspend fun getPosts(): List<Post>

}

