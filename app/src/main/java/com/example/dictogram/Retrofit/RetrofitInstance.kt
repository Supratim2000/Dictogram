package com.example.dictogram.Retrofit

import com.example.dictogram.Utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    //Retrofit instance
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val apiInterface: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    //Getter
    public fun getApiInterfaceInstance(): ApiService = this.apiInterface
}