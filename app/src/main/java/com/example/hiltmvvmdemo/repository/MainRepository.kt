package com.example.hiltmvvmdemo.repository

import com.example.hiltmvvmdemo.models.AlertsResponseClass
import com.example.hiltmvvmdemo.models.Product
import com.example.hiltmvvmdemo.network.ApiServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository
@Inject
constructor(private val apiServiceImpl: ApiServiceImpl) {

    fun getExpenseApiData(): Flow<ArrayList<Product>> = flow {
        emit(apiServiceImpl.getExpenseList())
    }.flowOn(Dispatchers.IO)
}