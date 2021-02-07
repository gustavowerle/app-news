package com.gw.appnews

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication : Application() {

    companion object {
        const val baseApiUrl: String = "https://newsapi.org/v2/"
    }

}