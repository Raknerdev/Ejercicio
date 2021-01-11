package com.pedroalvarez.ejercicio.data.apiservices


import com.google.gson.annotations.SerializedName

data class Article(
    val source: Source?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("urlToImage")
    val urlToImage: String?
)