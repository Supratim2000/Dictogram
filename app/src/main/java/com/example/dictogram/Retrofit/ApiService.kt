package com.example.dictogram.Retrofit

import com.example.dictogram.ModelClasses.ApiResponseClass
import com.example.dictogram.Utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("entries/en/{word}")
    fun getWordMeaning(
        @Path("word") word: String
    ): Call<List<ApiResponseClass>>
}