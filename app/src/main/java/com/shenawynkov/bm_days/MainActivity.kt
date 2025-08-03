package com.shenawynkov.bm_days

import Contact
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.shenawynkov.bm_days.networking.RetrofitClient
import com.shenawynkov.bm_days.ui.theme.BM_daysTheme
import contacts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    val postState = MutableStateFlow<String>("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contactsState = MutableStateFlow<List<Contact>>(emptyList())

        setContent {
            BM_daysTheme {

                DogScreen(postState) {

                    updatePhoto()
                }

            }

        }


        updatePhoto()


//        lifecycleScope.launch {
//           postState.value = RetrofitClient.apiService.getPosts()
//        }


//        lifecycleScope.launch(Dispatchers.IO) {
//            fetchData().collect { newData ->
//                contactsState.value += newData
//            }
//
//
//        }


    }

    private fun updatePhoto() {
        lifecycleScope.launch (Dispatchers.IO){
            postState.value = RetrofitClient.dogApiService.getRandomPic().message
        }

    }

    private fun fetchData() = flow {
        var start = 0
        var end = 20
        repeat(5)
        {
            delay(5000)
            emit(contacts.subList(start, end))
            start += 20
            end += 20

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }
}
