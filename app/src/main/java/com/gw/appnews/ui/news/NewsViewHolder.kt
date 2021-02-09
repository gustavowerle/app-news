package com.gw.appnews.ui.news

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gw.appnews.data.news.NewsPOJO
import com.gw.appnews.databinding.ItemNewsViewHolderBinding

class NewsViewHolder(private var binding: ItemNewsViewHolderBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun fill(news: NewsPOJO) {
        try {
            binding.textNewsTitle.text = news.title
            binding.textNewsDescription.text = news.description
            binding.apply {
                Glide.with(root)
                    .asBitmap()
                    .load(news.urlToImage)
                    .into(imageNews)
            }
        } catch (e: Exception) {
            Log.e("NewsViewsHolder -> fill", e.message.toString())
        }
    }
}