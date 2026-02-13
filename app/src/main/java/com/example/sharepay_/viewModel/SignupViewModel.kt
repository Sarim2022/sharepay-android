package com.example.sharepay_.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sharepay_.APIData.ApiClient
import com.example.sharepay_.APIData.SignupRequest
import kotlinx.coroutines.launch

class SignupViewModel : ViewModel() {

    fun signup(name: String, email: String, password: String, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = ApiClient.api.signup(
                    SignupRequest(name, email, password)
                )

                if (response.isSuccessful) {
                    onResult(true, "Signup successful")
                } else {
                    onResult(false, "Signup failed")
                }
            } catch (e: Exception) {
                onResult(false, e.message ?: "Network error")
            }
        }
    }
}
