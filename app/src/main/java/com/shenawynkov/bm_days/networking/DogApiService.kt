package com.shenawynkov.bm_days.networking

import com.shenawynkov.bm_days.data.DogResponse
import retrofit2.http.GET

interface DogApiService {
   @GET( "breeds/image/random")
   suspend fun getRandomPic():DogResponse
}