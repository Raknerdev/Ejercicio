package com.pedroalvarez.ejercicio.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pedroalvarez.ejercicio.data.database.FavoritePost

abstract class RecyclerHolderFavorites<T>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: FavoritePost, position:Int)
}