package com.gehazijenda.recipes.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String,
) : Parcelable

//list of categories object for getCategories API response
data class CategoriesResponse(val categories: List<Category>)