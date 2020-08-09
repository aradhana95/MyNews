package com.example.mynews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mynews.adapter.BookCategoryAdapter
import com.example.mynews.adapter.common.ItemClickListener
import com.example.mynews.entity.Book
import com.example.mynews.entity.BookCategory
import com.example.mynews.news.EditNews
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookCategoryAdapter = BookCategoryAdapter(object : ItemClickListener<Book> {
            override fun onClickListener(item: Book) {
                intent = Intent(applicationContext, EditNews::class.java)
                startActivity(intent)
               // Toast.makeText(baseContext, "You click ${item.title}", Toast.LENGTH_LONG).show()
            }
        })

        bookCategoryAdapter.submitList(getData())
        outerRecyclerView.adapter = bookCategoryAdapter
    }
    }

fun getData(): ArrayList<BookCategory> {
    val bookCategory = arrayListOf<BookCategory>()
    for (a in 1..5) {
        val bookList = arrayListOf<Book>()
        for(b in 1..5) {
            val book = Book("$b", "Book Title $b", R.drawable.book)
            bookList += book
        }

        bookCategory += BookCategory("$a", "Category title $a", bookList)
    }

    return bookCategory
}
