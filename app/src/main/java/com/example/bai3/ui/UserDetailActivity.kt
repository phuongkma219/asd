package com.example.bai3.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.bai3.MyApplication
import com.example.bai3.databinding.ActivityDetailUserBinding
import com.example.bai3.model.User
import com.example.bai3.viewmodel.UserViewModel

class UserDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding
    private val userViewModel: UserViewModel by viewModels {
        UserViewModel.UserViewModelFactory((application as MyApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val item = intent.getSerializableExtra("123") as User
        binding.item = item
        binding.btnDelete.setOnClickListener {
            userViewModel.delete(item)
            val intent = Intent()
            intent.setClass(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnUpdate.setOnClickListener {
            val user = User(binding.etRegName.text.toString(),binding.etRegPhone.text.toString())
            userViewModel.update(item.id!!,user.name,user.phone)
            val intent = Intent()
            intent.setClass(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}