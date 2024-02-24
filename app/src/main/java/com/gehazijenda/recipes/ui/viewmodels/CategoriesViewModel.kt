package com.gehazijenda.recipes.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gehazijenda.recipes.data.api.recipeService
import com.gehazijenda.recipes.data.model.Category
import kotlinx.coroutines.launch

class CategoriesViewModel : ViewModel() {

    //category state which is observed
    private val _categoryState = mutableStateOf(
        CategoriesStateClass()
    )

    //category state exposed to the UI
    val categoriesState: State<CategoriesStateClass> = _categoryState

    //call fetchCategories upon initialization
    init {
        fetchCategories()
    }



    //function to fetch the categories
    private fun fetchCategories() {
        //viewModelScope enables us to write asynchronous code using Kotlin Coroutines
        //and we can access the coroutine scope through it
        //any coroutine launched in this scope is automatically cancelled is the ViewModel is destroyed
        viewModelScope.launch {
            //try get the categories and catch any errors
            try{
                //get the API Service created using retrofit
                val response = recipeService.getCategories()
                _categoryState.value = _categoryState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    error = "Error fetching categories : ${e.message}"
                )
            }
        }
    }



    //data class for keeping state of categories
    data class CategoriesStateClass(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null,
    )
}