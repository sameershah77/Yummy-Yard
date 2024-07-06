package com.example.yummyyards.APIs

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://fls8oe8xp7.execute-api.ap-south-1.amazonaws.com/dev/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: NoshApi by lazy {
        retrofit.create(NoshApi::class.java)
    }
}
