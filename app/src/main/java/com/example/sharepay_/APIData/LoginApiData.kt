package com.example.sharepay_.APIData

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val message: String
)
