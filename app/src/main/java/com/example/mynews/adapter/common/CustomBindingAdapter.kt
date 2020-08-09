package com.example.mynews.adapter.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mynews.adapter.BookAdapter
import com.example.mynews.entity.Book

@BindingAdapter(value = ["setBooks", "setBookListener"])
fun RecyclerView.setRowBook(books: List<Book>?, listener: ItemClickListener<Book>?) {
    if (books != null && listener != null) {
        val bookAdapter = BookAdapter(listener)
        bookAdapter.submitList(books)

        adapter = bookAdapter
    }
}