package com.gw.appnews.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gw.appnews.databinding.MainFragmentBinding
import com.gw.appnews.ui.news.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private var mLayoutManager: LinearLayoutManager? = null
    private var newsAdapter: NewsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.bootstrap()
        setNavigationMenuBehaviour()
        setUpInfiniteScrolling()
    }

    private fun setNavigationMenuBehaviour() {
        binding.navigationMenu.setOnNavigationItemSelectedListener {
            viewModel.newsList.value?.clear()
            newsAdapter?.notifyDataSetChanged()
            viewModel.onNavigationItemSelected(it)
        }
    }

    private fun setUpInfiniteScrolling() {
        try {
            mLayoutManager = LinearLayoutManager(requireActivity())
            newsAdapter = NewsAdapter()
            binding.recyclerNews.apply {
                setHasFixedSize(true)
                layoutManager = mLayoutManager
                adapter = newsAdapter
            }
            viewModel.newsList.observe(viewLifecycleOwner, {
                newsAdapter!!.submitList(null)
                newsAdapter!!.submitList(it)
            })
        } catch (e: Exception) {
            Log.e(tag, e.message, e)
        }
    }
}