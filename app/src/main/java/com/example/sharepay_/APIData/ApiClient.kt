package com.example.sharepay_.APIData

object ApiClient {

    private const val BASE_URL = "http://10.0.2.2:8080/"


    val api: AuthApi by lazy {
        retrofit.create(AuthApi::class.java)
    }

    private val retrofit = retrofit2.Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
        .build()
}
