package com.pedroalvarez.ejercicio.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pedroalvarez.ejercicio.R
import com.pedroalvarez.ejercicio.data.apiservices.Article
import kotlinx.android.synthetic.main.card_view.view.*
import java.lang.IllegalArgumentException

class RecyclerAdapter(
    private val context: Context?,
    private val listNews: List<Article>,
    private val itemClickListener: OnPostClick
    ): RecyclerView.Adapter<RecyclerHolder<*>>(){

    interface OnPostClick{
        fun onPostNavClick(url: String?)
        fun onFavoriteClick(title: String?, url: String?, urlToImage: String?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder<*> {
        return RecyclerViewHolder(
            LayoutInflater.from(context).inflate(R.layout.card_view,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerHolder<*>, position: Int) {
        when(holder){
            is RecyclerViewHolder -> holder.bind(listNews[position],position)
            else -> throw IllegalArgumentException("No se paso el viewHolder en el bind")
        }
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
    inner class RecyclerViewHolder(itemView: View):RecyclerHolder<Article>(itemView){
        override fun bind(item: Article, position: Int) {

            itemView.setOnClickListener{
                itemClickListener.onPostNavClick(item.url)
            }
            itemView.addFavorites.setOnClickListener{
                itemClickListener.onFavoriteClick(item.title, item.url, item.urlToImage)
            }

            Glide.with(context!!).load(item.urlToImage).into(itemView.imgCard)
            itemView.tittleCard.text = item.title
        }

    }
}
