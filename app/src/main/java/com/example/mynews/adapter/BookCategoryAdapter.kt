package com.example.mynews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mynews.adapter.common.CustomViewHolder
import com.example.mynews.adapter.common.ItemClickListener
import com.example.mynews.databinding.ItemBookCategoryBinding
import com.example.mynews.entity.Book
import com.example.mynews.entity.BookCategory

class BookCategoryAdapter(private val listener: ItemClickListener<Book>) : ListAdapter<BookCategory, CustomViewHolder>(Companion) {
    companion object : DiffUtil.ItemCallback<BookCategory>() {
        private val viewPool = RecyclerView.RecycledViewPool()

        override fun areItemsTheSame(oldItem: BookCategory, newItem: BookCategory): Boolean {
            return  oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: BookCategory, newItem: BookCategory): Boolean {
            return  oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBookCategoryBinding.inflate(inflater, parent, false)

        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentBookCategory = getItem(position)
        val itemBinding = holder.binding as ItemBookCategoryBinding

        itemBinding.bookListener = listener
        itemBinding.bookCategory = currentBookCategory
        itemBinding.nestedRecyclerView.setRecycledViewPool(viewPool)
        itemBinding.executePendingBindings()
    }
}