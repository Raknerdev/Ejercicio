package com.pedroalvarez.ejercicio.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pedroalvarez.ejercicio.R
import com.pedroalvarez.ejercicio.adapter.RecyclerAdapter
import com.pedroalvarez.ejercicio.data.ApiServices
import com.pedroalvarez.ejercicio.data.ArticleDataItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FavoritesFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_favorites, container, false)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create<ApiServices>(ApiServices::class.java)

        api.getListArticles().enqueue(object : retrofit2.Callback<ArticleDataItem> {
            override fun onResponse(
                call: Call<ArticleDataItem>,
                response: Response<ArticleDataItem>
            ) {
                val article = response?.body()
                val recyclerPost = vista.findViewById(R.id.recyclerViewFav) as RecyclerView
                recyclerPost.layoutManager = LinearLayoutManager(context)
                recyclerPost.adapter = RecyclerAdapter(context, article!!.articles!!)
                Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<ArticleDataItem>, t: Throwable) {
                Toast.makeText(context, "ERROR", Toast.LENGTH_LONG).show()
            }

        })
        return vista
    }
}