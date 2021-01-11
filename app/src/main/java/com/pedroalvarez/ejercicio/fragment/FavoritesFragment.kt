package com.pedroalvarez.ejercicio.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pedroalvarez.ejercicio.NavPost
import com.pedroalvarez.ejercicio.R
import com.pedroalvarez.ejercicio.adapter.RecyclerAdapterFavorites
import com.pedroalvarez.ejercicio.data.database.FavoritePost
import com.pedroalvarez.ejercicio.data.database.Favpost
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class FavoritesFragment: Fragment(), RecyclerAdapterFavorites.OnFavoritesClick {

    lateinit var postFav: MutableList<FavoritePost>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_favorites, container, false)
        //GetDataBase
        doAsync {
            postFav = Favpost.database.favoriteDao().getFavoritePost()
            uiThread {
                //RecyclerView
                val recyclerPost = vista.findViewById(R.id.recyclerViewFav) as RecyclerView
                recyclerPost.layoutManager = LinearLayoutManager(context)

                recyclerPost.adapter = RecyclerAdapterFavorites(context, postFav, this@FavoritesFragment)
            }
        }
        return vista
    }
    override fun onPostNavClick(url: String?) {
        val intent = Intent(context, NavPost::class.java)
        intent.putExtra("Url", url)
        startActivity(intent)
    }
    override fun onPostDelete(title: String, url: String, urlImg: String) {
        doAsync {
            Favpost.database.favoriteDao().deleteFavorite(
                FavoritePost("$title", "$url", "$urlImg"))
            postFav.remove(title)
        }
        Toast.makeText(context, "Delete", Toast.LENGTH_LONG).show()
    }
}