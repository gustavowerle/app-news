package com.gw.appnews.data.news

import com.squareup.moshi.Json

data class NewsResponse(
    @field:Json(name = "articles") val articles: List<NewsPOJO>,
    @field:Json(name = "status") val status: String,
    @field:Json(name = "totalResults") val totalResults: Int
)