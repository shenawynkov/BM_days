package com.shenawynkov.bm_days.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shenawynkov.bm_days.data.models.Post
import com.shenawynkov.bm_days.data.repo.PostsRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewmodel(private val repo: PostsRepo) : ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts


    fun fetchData() {
        viewModelScope.launch {
            repo.fetchPosts()
        }
        observePosts()
    }

    private fun observePosts()
    {
        viewModelScope.launch {
            repo.getPosts().collect() { posts->
                _posts.value = posts

            }
        }
    }











}