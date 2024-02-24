package com.gehazijenda.recipes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gehazijenda.recipes.ui.screens.CategoriesScreen
import com.gehazijenda.recipes.ui.screens.HomeScreen
import com.gehazijenda.recipes.ui.screens.Screen
import com.gehazijenda.recipes.ui.viewmodels.CategoriesViewModel

@Composable
fun RecipeApp(navHostController: NavHostController) {
    //init view model for categories
    val categoriesViewModel: CategoriesViewModel = viewModel()
    val categoriesState by categoriesViewModel.categoriesState

    NavHost(navController = navHostController, startDestination = Screen.HomeScreen.route) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(categoriesState)
        }

    }
}