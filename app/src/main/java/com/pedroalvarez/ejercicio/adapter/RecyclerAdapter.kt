package com.pedroalvarez.ejercicio.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pedroalvarez.ejercicio.R
import com.pedroalvarez.ejercicio.data.Article
import kotlinx.android.synthetic.main.card_view.view.*
import java.lang.IllegalArgumentException

class RecyclerAdapter(
    private val context: Context?,
    private val listNews: List<Article>
    ): RecyclerView.Adapter<RecyclerHolder<*>>(){

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
            Glide.with(context!!).load(item.urlToImage).into(itemView.imgCard)
            itemView.tittleCard.text = item.title
        }

    }
}
