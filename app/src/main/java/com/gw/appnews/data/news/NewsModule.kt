package com.gw.appnews.data.news

import com.gw.appnews.NewsApplication.Companion.baseApiUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)
class NewsModule {
    @Provides
    fun provideNewsService(): NewsService {
        return Retrofit.Builder()
            .baseUrl(baseApiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsService::class.java);
    }
}