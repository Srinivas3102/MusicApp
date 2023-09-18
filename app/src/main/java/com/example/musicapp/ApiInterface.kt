package com.example.musicapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers("X-RapidAPI-Key: b1c3538379msh8cb27ad18aed1f8p1a22aajsnc122c455013e","X-RapidAPI-Host:deezerdevs-deezer.p.rapidapi.com")
    @GET("search")  // Replace with the actual endpoint path
    fun getData(@Query("q") query: String): Call<Mydata?>
}
