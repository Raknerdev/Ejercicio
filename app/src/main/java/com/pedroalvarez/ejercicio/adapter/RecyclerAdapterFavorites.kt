package com.pedroalvarez.ejercicio.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pedroalvarez.ejercicio.R
import com.pedroalvarez.ejercicio.data.database.FavoritePost
import kotlinx.android.synthetic.main.card_view_favorites.view.*
import java.lang.IllegalArgumentException

class RecyclerAdapterFavorites(
    private val context: Context?,
    private val listNews: List<FavoritePost>,
    private val itemClickListener: OnFavoritesClick
): RecyclerView.Adapter<RecyclerHolderFavorites<*>>(){

    interface OnFavoritesClick{
        fun onPostNavClick(url: String?)
        fun onPostDelete(title: String, url: String, urlImg: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolderFavorites<*> {
        return RecyclerViewHolderFavorites(
            LayoutInflater.from(context).inflate(R.layout.card_view_favorites,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerHolderFavorites<*>, position: Int) {
        when(holder){
            is RecyclerViewHolderFavorites -> holder.bind(listNews[position],position)
            else -> throw IllegalArgumentException("No se paso el viewHolder en el bind")
        }
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
    inner class RecyclerViewHolderFavorites(itemView: View):RecyclerHolderFavorites<FavoritePost>(itemView){
        override fun bind(item: FavoritePost, position: Int) {
            itemView.deleteFavorites.setOnClickListener {
                itemClickListener.onPostDelete(item.title, item.url, item.urlImg)
            }
            itemView.setOnClickListener{
                itemClickListener.onPostNavClick(item.url)
            }
            Glide.with(context!!).load(item.urlImg).into(itemView.imgCardFav)
            itemView.tittleCardFav.text = item.title
        }

    }


}