package com.example.hiltmvvmdemo.network

import com.example.hiltmvvmdemo.models.AlertsResponseClass
import com.example.hiltmvvmdemo.network.ApiService
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {

    suspend fun getExpenseList(mHashMap: HashMap<String, Any>): AlertsResponseClass = apiService.getExpenseLists(mHashMap)
}