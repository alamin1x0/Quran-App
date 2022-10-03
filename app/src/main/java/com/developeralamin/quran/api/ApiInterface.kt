package com.developeralamin.quran.api

import com.developeralamin.quran.model.QuranModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/surat")
    suspend fun getQuranData(): Response<QuranModel>
}