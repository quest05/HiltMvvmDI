package com.example.hiltmvvmdemo.models

import com.example.hiltmvvmdemo.models.Alert

data class AlertsResponseClass(
    val alerts: ArrayList<Alert>,
    val customcode: Int,
    val error: Boolean,
    val errors: String,
    val message: String,
    val page: Int,
    val per_page: Int,
    val status: String,
    val total: Int,
    val total_pages: Int
)