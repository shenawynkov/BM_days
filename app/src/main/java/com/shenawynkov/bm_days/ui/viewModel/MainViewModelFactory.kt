package com.shenawynkov.bm_days.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shenawynkov.bm_days.data.repo.PostsRepo

class MainViewModelFactory(private val repo: PostsRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewmodel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewmodel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}