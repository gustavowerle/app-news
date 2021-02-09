package com.gw.appnews.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.gw.appnews.data.news.NewsPOJO
import com.gw.appnews.databinding.ItemNewsViewHolderBinding

class NewsAdapter : ListAdapter<NewsPOJO, NewsViewHolder>(NewsDiffer()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemNewsViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.fill(getItem(position))
    }
}