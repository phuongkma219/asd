package com.example.bai3.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.bai3.MyApplication
import com.example.bai3.databinding.ActivityAddUserBinding
import com.example.bai3.model.User
import com.example.bai3.viewmodel.UserViewModel

class AddUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddUserBinding
    private val userViewModel: UserViewModel by viewModels {
        UserViewModel.UserViewModelFactory((application as MyApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            val user = User(binding.etRegName.text.toString(),binding.etRegPhone.text.toString())
            userViewModel.insert(user)
            val intent = Intent()
            intent.setClass(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}