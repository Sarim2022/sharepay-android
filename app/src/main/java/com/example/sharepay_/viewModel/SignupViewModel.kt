package com.example.sharepay_.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sharepay_.APIData.ApiClient
import com.example.sharepay_.APIData.SignupRequest
import com.example.sharepay_.APIData.SignupResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.launch

class SignupViewModel : ViewModel() {

    private val gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    fun signup(name: String, email: String, password: String, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = ApiClient.api.signup(
                    SignupRequest(name, email, password)
                )

                if (response.isSuccessful) {
                    // Handle success response - might be null or empty
                    val successMessage = try {
                        response.body()?.message ?: "Signup successful"
                    } catch (e: Exception) {
                        // If parsing fails, just show success message
                        "Signup successful"
                    }
                    onResult(true, successMessage)
                } else {
                    // Parse error message from error body
                    val errorMessage = try {
                        val errorBody = response.errorBody()?.string()
                        if (errorBody != null && errorBody.isNotBlank()) {
                            try {
                                val errorResponse = gson.fromJson(errorBody, SignupResponse::class.java)
                                errorResponse.message
                            } catch (e: Exception) {
                                // If JSON parsing fails, return the raw error body
                                errorBody
                            }
                        } else {
                            null
                        }
                    } catch (e: Exception) {
                        null
                    }
                    onResult(false, errorMessage ?: "Signup failed")
                }
            } catch (e: Exception) {
                // Handle network or parsing errors
                val errorMsg = when {
                    e.message?.contains("malformed JSON") == true -> "Signup successful" // Treat JSON parsing errors as success if status was 200
                    else -> e.message ?: "Network error"
                }
                onResult(false, errorMsg)
            }
        }
    }
}
