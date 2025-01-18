package com.example.hiltmvvmdemo.network

import com.example.hiltmvvmdemo.models.Product
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getExpenseLists(): ArrayList<Product>
}