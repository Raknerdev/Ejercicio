package com.pedroalvarez.ejercicio.data.apiservices

import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("top-headlines?country=us&apiKey=28f6b01889f3486597e097e61c8418ae")
    fun getListArticles(): Call<ArticleDataItem>
}