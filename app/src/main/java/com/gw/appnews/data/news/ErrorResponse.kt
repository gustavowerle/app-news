package com.gw.appnews.data.news

import com.squareup.moshi.Json

data class ErrorResponse(
    @field:Json(name = "message") val message: String
)