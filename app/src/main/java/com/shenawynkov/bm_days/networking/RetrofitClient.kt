package com.shenawynkov.bm_days.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private const val DOG_BASE_URL = "https://dog.ceo/api/"

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }).build()

    private val retrofit = Retrofit.Builder().client(okHttpClient).baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()


    val apiService = retrofit.create(ApiService::class.java)
    // apiservice = ApiServiceImpl


    private val retrofitDOG = Retrofit.Builder().client(okHttpClient).baseUrl(DOG_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    val dogApiService = retrofitDOG.create(DogApiService::class.java).apply {

    }


}




