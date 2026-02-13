package com.example.sharepay_.APIData


data class SignupRequest(
    val name: String,
    val email: String,
    val password: String
)

data class SignupResponse(
    val message: String
)
