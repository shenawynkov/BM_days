package com.shenawynkov.bm_days

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shenawynkov.bm_days.data.Post
import kotlinx.coroutines.flow.StateFlow

@Composable
fun InstaScreen(photosState:StateFlow<List<Post>>) {
    val posts by photosState.collectAsState()


    LazyColumn {
        items(posts, key = { it.id })
        { post ->
           PostCard(post)

        }
    }

}


@Composable
fun PostCard(post: Post) {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {




        Text(text = post.title, color = Color.Blue, fontSize = 18.sp)
        Text(text = post.body, color = Color.Gray, fontSize = 12.sp)


    }
}
