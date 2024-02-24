package com.gehazijenda.recipes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gehazijenda.recipes.data.model.Category
import com.gehazijenda.recipes.ui.components.CategoryItem
import com.gehazijenda.recipes.ui.components.TextComponent
import com.gehazijenda.recipes.ui.viewmodels.CategoriesViewModel

@Composable
fun CategoriesScreen(
    viewState: CategoriesViewModel.CategoriesStateClass
) {
    Box (
        modifier = Modifier.fillMaxSize()
            .padding(vertical = 10.dp)
    ) {
        //display the appropriate composable based on the state of the categories view model
        when {
            viewState.loading -> {
                CircularProgressIndicator(
                    Modifier.align(
                        Alignment.Center
                    )
                )
            }

            viewState.error != null -> {
                TextComponent(text = viewState.error)
            }

            else -> {
                CategoriesList(categories = viewState.list)
            }

        }
    }
}

@Composable
fun CategoriesList(categories: List<Category>) {
    LazyVerticalGrid(
        GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 15.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalArrangement = Arrangement.spacedBy(50.dp),
        modifier = Modifier.fillMaxSize()) {
        //the lazyGridItemScope provides items
        items(categories) {
            category -> CategoryItem(category = category)
        }
    }
}