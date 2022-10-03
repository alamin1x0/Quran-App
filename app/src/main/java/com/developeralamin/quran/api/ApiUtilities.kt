package com.developeralamin.quran.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilities {

    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://equran.id/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}