package com.gw.appnews.ui.main

import android.util.Log
import android.view.MenuItem
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gw.appnews.R
import com.gw.appnews.data.news.NewsPOJO
import com.gw.appnews.data.news.NewsHTTPService
import com.gw.appnews.ui.news.NewsCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val HTTPService: NewsHTTPService) : ViewModel() {

    var newsList: MutableLiveData<MutableList<NewsPOJO>> =
        MutableLiveData(mutableListOf())

    fun bootstrap() {
        getNews(NewsCategory.GENERAL)
    }

    fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuGeneral -> {
                getNews(NewsCategory.GENERAL)
                return true
            }
            R.id.menuTechnology -> {
                getNews(NewsCategory.TECHNOLOGY)
                return true
            }
            R.id.menuBusiness -> {
                getNews(NewsCategory.BUSINESS)
                return true
            }
            R.id.menuHealth -> {
                getNews(NewsCategory.HEALTH)
                return true
            }
            R.id.menuScience -> {
                getNews(NewsCategory.SCIENCE)
                return true
            }
        }
        return false
    }

    fun getNews(filter: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = HTTPService.getNews(category = filter).execute()
                val currentList = newsList.value ?: mutableListOf()
                currentList.addAll(result.body()!!.articles)
                viewModelScope.launch(Dispatchers.Main) {
                    newsList.value = currentList
                }
                Log.d("getNews", currentList.toString())
            } catch (e: Exception) {
                Log.e("getNews", e.toString())
            }
        }
    }
}