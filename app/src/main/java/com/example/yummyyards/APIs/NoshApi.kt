package com.example.yummyyards.APIs

import com.example.yummyyards.models.Dish
import retrofit2.http.GET

interface NoshApi {
    @GET("nosh-assignment")
    suspend fun getDishes(): List<Dish>
}
