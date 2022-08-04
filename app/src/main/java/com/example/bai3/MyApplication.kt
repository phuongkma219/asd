package com.example.bai3

import android.app.Application
import com.example.bai3.model.database.UserDatabase
import com.example.bai3.model.repository.UserRepository

class MyApplication:Application() {
    private val database by lazy { UserDatabase.getDatabase(this) }
    val repository by lazy { UserRepository(database.userDao()) }
}