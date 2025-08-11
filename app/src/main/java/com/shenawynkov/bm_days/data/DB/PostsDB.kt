package com.shenawynkov.bm_days.data.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PostEntity::class], version = 1)
abstract class PostsDB : RoomDatabase() {
    abstract fun getPostDoa(): PostDao


    companion object {
        private var instance: PostsDB? = null

        fun getDB(context: Context): PostsDB {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    PostsDB::class.java,
                    "posts_db"
                ).build()
            }
            return instance!!
        }


    }


}