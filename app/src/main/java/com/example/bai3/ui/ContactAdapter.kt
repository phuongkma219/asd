package com.example.bai3.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bai3.databinding.ItemContactBinding
import com.example.bai3.model.User

class ContactAdapter(private val inner: IContact) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    var list: MutableList<User> = arrayListOf()

    class ContactViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.binding.item = list.get(position)
        holder.binding.cvContainer.setOnClickListener {
            inner.onClickItem(list.get(position), holder.adapterPosition)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface IContact {
        fun onClickItem(item: User, position: Int)
    }
}