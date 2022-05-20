package com.example.afinal

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("countries")
    fun getCountries(): Call<List<Country>>
}