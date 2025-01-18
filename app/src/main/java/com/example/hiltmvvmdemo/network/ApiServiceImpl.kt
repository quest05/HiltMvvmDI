package com.example.hiltmvvmdemo.network

import com.example.hiltmvvmdemo.models.Product
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {

    suspend fun getExpenseList(): ArrayList<Product> = apiService.getExpenseLists()
}