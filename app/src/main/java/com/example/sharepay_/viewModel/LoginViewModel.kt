package com.example.sharepay_.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sharepay_.APIData.ApiClient
import com.example.sharepay_.APIData.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    fun login(email: String, password: String, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = ApiClient.api.login(
                    LoginRequest(email, password)
                )

                if (response.isSuccessful && response.body()?.message == "Login successful") {
                    onResult(true, "Login successful")
                } else {
                    onResult(false, response.body()?.message ?: "Login failed")
                }
            } catch (e: Exception) {
                onResult(false, e.message ?: "Network error")
            }
        }
    }
}
