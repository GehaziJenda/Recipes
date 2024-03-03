package com.gehazijenda.recipes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.gehazijenda.recipes.data.constants.AppColors
import com.gehazijenda.recipes.ui.components.TextComponent
import com.gehazijenda.recipes.ui.viewmodels.CategoriesViewModel
import com.gehazijenda.recipes.ui.viewmodels.RegionsViewModel


@Composable
fun HomeScreen(categoriesViewState : CategoriesViewModel.CategoriesStateClass,
               regionsViewState: RegionsViewModel.RegionsStateClass) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                title = {
                    TextComponent(
                        text = "WELCOME",
                        color = Color.Black,
                        size = 18.sp
                        )
                },
                backgroundColor = AppColors.appBarGrey,
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                }
            )
        }
    ) { padding ->
        Column (
            modifier = Modifier.padding(padding)
        ) {
            TabView(categoriesViewState, regionsViewState)
        }
    }
}