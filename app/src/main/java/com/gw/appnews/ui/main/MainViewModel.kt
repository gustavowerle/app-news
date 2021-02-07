package com.gw.appnews.ui.main

import android.util.Log
import android.view.MenuItem
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gw.appnews.R
import com.gw.appnews.data.news.NewsPOJO
import com.gw.appnews.data.news.NewsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val service: NewsService) : ViewModel() {

    var newsPOJO: MutableLiveData<MutableList<NewsPOJO>> =
        MutableLiveData(mutableListOf())

    fun onNavigationItemSelected(item: MenuItem) : Boolean {
        when (item.itemId) {
            R.id.menuGeneral -> {
                getNews("general")
                return true
            }
            R.id.menuTechnology -> {
                getNews("technology")
                return true
            }
            R.id.menuBusiness -> {
                getNews("business")
                return true
            }
            R.id.menuHealth -> {
                getNews("health")
                return true
            }
            R.id.menuScience -> {
                getNews("science")
                return true
            }
        }
        return false
    }

    private fun getNews(filter: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = service.getNews(filter).execute()
                val currentList = newsPOJO.value ?: mutableListOf()
                currentList.addAll(result.body()!!.articles)
                Log.d("getNews", currentList.toString())
            } catch (e: Exception) {
                Log.e("getNews", e.toString())
            }
        }
    }

}