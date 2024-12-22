package com.example.hiltmvvmdemo.network

import com.example.hiltmvvmdemo.models.AlertsResponseClass
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {

    @GET("alert/moduleAlerts")
    suspend fun getExpenseLists(@QueryMap data: HashMap<String, @JvmSuppressWildcards Any>): AlertsResponseClass
}