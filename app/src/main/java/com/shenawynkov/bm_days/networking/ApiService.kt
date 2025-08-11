package com.shenawynkov.bm_days.networking

import com.shenawynkov.bm_days.data.models.Photo
import com.shenawynkov.bm_days.data.models.Post
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getPhotos(): List<Photo>

    @GET("posts")
    suspend fun getPosts(): List<Post>

}

class ApiServiceImpl : ApiService {
    override suspend fun getPhotos(): List<Photo> {
        // use http client to call server
        // check for exception
        // use gson converter to convert to data classes
        TODO("Not yet implemented")

    }

    override suspend fun getPosts(): List<Post> {
        TODO("Not yet implemented")
    }


}