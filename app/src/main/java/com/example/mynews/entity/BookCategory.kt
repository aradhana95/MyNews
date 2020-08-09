package com.example.mynews.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookCategory(
    val id: String,
    val title: String,
    val books: List<Book>
) : Parcelable