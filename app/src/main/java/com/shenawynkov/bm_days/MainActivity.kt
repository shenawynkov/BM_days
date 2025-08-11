package com.shenawynkov.bm_days

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.shenawynkov.bm_days.data.DB.PostsDB
import com.shenawynkov.bm_days.data.repo.PostsRepo
import com.shenawynkov.bm_days.ui.theme.BM_daysTheme
import com.shenawynkov.bm_days.ui.viewModel.MainViewModelFactory
import com.shenawynkov.bm_days.ui.viewModel.MainViewmodel
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.core.content.edit


class MainActivity : ComponentActivity() {
    private val viewmodel: MainViewmodel by viewModels()
    {
        MainViewModelFactory(repo)
    }
    private val repo: PostsRepo by lazy {
        val db= PostsDB.getDB(context = applicationContext)
        PostsRepo(db)
    }

    val pref:SharedPreferences  by lazy {
        applicationContext.getSharedPreferences("dark", MODE_PRIVATE)
    }
    val darkState= MutableStateFlow(true)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        darkState.value=pref.getBoolean("dark_mode",true)
        viewmodel.fetchData()

        setContent {
            BM_daysTheme {

              //  InstaScreen(viewmodel)
                PrefScreen(darkState) { toggleDarkPref()}

            }

        }




    }

    fun toggleDarkPref()
    {
        pref.edit(commit = true) {

            putBoolean("dark_mode", !darkState.value)// write

            darkState.value=
        }


    }




}

