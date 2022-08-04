package com.example.bai3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bai3.MyApplication
import com.example.bai3.R
import com.example.bai3.databinding.ActivityMainBinding
import com.example.bai3.model.User
import com.example.bai3.viewmodel.UserViewModel

class MainActivity : AppCompatActivity(), ContactAdapter.IContact, SearchView.OnQueryTextListener {
    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels {
        UserViewModel.UserViewModelFactory((application as MyApplication).repository)
    }
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userViewModel.getAll()
        adapter = ContactAdapter(this)
        binding.rvContact.adapter = adapter
        binding.rvContact.layoutManager = LinearLayoutManager(this)
        userViewModel.users.observe(this, {
            adapter.list = it
            adapter.notifyDataSetChanged()
        })
        binding.btnFloating.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, AddUserActivity::class.java)
            startActivity(intent)
        }
        binding.searchView.setOnQueryTextListener(this)
    }

    override fun onClickItem(item: User, position: Int) {
        val intent = Intent()
        intent.setClass(this, UserDetailActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("123", item)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        Log.d("kkk", "onQueryTextSubmit: ${query}")
        if (query.equals("")) {
            userViewModel.getAll()
        } else {
            userViewModel.findByKeySearch(query!!)

        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.d("kkk", "onQueryTextChange: ${newText}")

        return false

    }
}