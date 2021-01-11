package com.pedroalvarez.ejercicio.data.apiservices


import com.google.gson.annotations.SerializedName

data class ArticleDataItem(
    @SerializedName("articles")
    val articles: List<Article>?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
)