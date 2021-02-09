package com.gw.appnews.ui.news

import androidx.recyclerview.widget.DiffUtil
import com.gw.appnews.data.news.NewsPOJO

class NewsDiffer : DiffUtil.ItemCallback<NewsPOJO>() {

    override fun areItemsTheSame(oldItem: NewsPOJO, newItem: NewsPOJO): Boolean = oldItem.url == newItem.url

    override fun areContentsTheSame(oldItem: NewsPOJO, newItem: NewsPOJO): Boolean = oldItem.title == newItem.title
}