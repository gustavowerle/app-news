package com.gw.appnews.data.news

data class NewsPOJO(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val sourcePOJO: NewsSourcePOJO,
    val title: String,
    val urlToImage: String,
    val url: String
)