package com.pedroalvarez.ejercicio.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pedroalvarez.ejercicio.data.Article

abstract class RecyclerHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: Article, position:Int)
}