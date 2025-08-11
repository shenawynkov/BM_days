package com.shenawynkov.bm_days.data.repo

import com.shenawynkov.bm_days.data.DB.PostEntity
import com.shenawynkov.bm_days.data.DB.PostsDB
import com.shenawynkov.bm_days.data.models.Post
import com.shenawynkov.bm_days.networking.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class PostsRepo(private val postsDB: PostsDB) {

    fun getPosts(): Flow<List<Post>> {
        return postsDB.getPostDoa().getPosts().map { list ->
            list.map { postsEntity ->
                Post(
                    id = postsEntity.id,
                    body = postsEntity.body,
                    title = postsEntity.title,
                    userId = postsEntity.userId
                )
            }
        }
    }

    suspend fun fetchPosts() {
        withContext(Dispatchers.IO)
        {
            val postsEntities = RetrofitClient.apiService.getPosts().map { post ->
                PostEntity(id = post.id, body = post.body, title = post.title, userId = post.userId)

            }
            val postDao = postsDB.getPostDoa()
            postDao.addAllPosts(postsEntities)

        }

    }
}