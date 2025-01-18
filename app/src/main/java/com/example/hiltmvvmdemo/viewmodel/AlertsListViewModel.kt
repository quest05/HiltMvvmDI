package com.example.hiltmvvmdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltmvvmdemo.repository.MainRepository
import com.example.hiltmvvmdemo.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlertsListViewModel
@Inject
constructor(private val mainRepository: MainRepository) : ViewModel() {

    val postStateFlow: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)

    fun getExpenseListItem() = viewModelScope.launch {
        postStateFlow.value = ApiState.Loading
        mainRepository.getExpenseApiData()
            .catch { e ->
                postStateFlow.value = ApiState.Failure(e)
            }.collect { data ->
                postStateFlow.value = ApiState.Success(data)
            }
    }
}