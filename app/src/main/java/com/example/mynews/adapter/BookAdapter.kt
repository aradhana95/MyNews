package com.example.mynews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.mynews.adapter.common.CustomViewHolder
import com.example.mynews.adapter.common.ItemClickListener
import com.example.mynews.databinding.ItemBookBinding
import com.example.mynews.entity.Book

class BookAdapter(val listener: ItemClickListener<Book>) : ListAdapter<Book, CustomViewHolder>(Companion) {
    companion object : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return  oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return  oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBookBinding.inflate(inflater, parent, false)

        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentBook = getItem(position)
        val itemBinding = holder.binding as ItemBookBinding

        itemBinding.root.setOnClickListener { listener.onClickListener(currentBook) }
        itemBinding.book = currentBook
        itemBinding.executePendingBindings()
    }
}