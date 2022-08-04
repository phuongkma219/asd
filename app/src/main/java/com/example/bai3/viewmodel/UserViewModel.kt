package com.example.bai3.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.bai3.model.User
import com.example.bai3.model.database.UserDatabase
import com.example.bai3.model.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    var users: MutableLiveData<MutableList<User>> = MutableLiveData()
    fun insert( user: User) = viewModelScope.launch(Dispatchers.IO){
        userRepository.insert(user)
    }

    fun getAll() = viewModelScope.launch(Dispatchers.IO){
        users.postValue( userRepository.getAll())
    }
    fun findByKeySearch(keySearch: String) = viewModelScope.launch(Dispatchers.IO){
        users.postValue( userRepository.findByKeySearch(keySearch))
    }
    fun delete( user: User) = viewModelScope.launch (Dispatchers.IO){
        userRepository.delete(user)
    }

    fun update(id:Int,name : String,phone:String) = viewModelScope.launch(Dispatchers.IO){
       userRepository.update(id, name, phone)
    }


    class UserViewModelFactory(private val userRepository: UserRepository)
        : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return UserViewModel(userRepository) as T
            }
            throw IllegalArgumentException("Unknown VieModel Class")
        }

    }
}