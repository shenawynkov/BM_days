package com.shenawynkov.bm_days.data.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPost(post: PostEntity)


    @Query("SELECT * FROM PostEntity")
    fun getPosts(): Flow<List<PostEntity>>


    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllPosts(posts:List<PostEntity>)

}