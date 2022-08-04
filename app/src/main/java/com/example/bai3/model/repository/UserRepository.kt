package com.example.bai3.model.repository

import androidx.annotation.WorkerThread
import com.example.bai3.model.User
import com.example.bai3.model.database.UserDao

class UserRepository(private val userDao :UserDao) {
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(user: User){
        userDao.insert(user)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(user: User){
        userDao.delete(user)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(id:Int,name : String,phone:String){
        userDao.update(id,name, phone)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAll(): MutableList<User>? {
       return userDao.getAll()
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun findByKeySearch(keySearch: String): MutableList<User>? {
        return userDao.findByKeySearch(keySearch)
    }

}