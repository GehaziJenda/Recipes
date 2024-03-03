package com.gehazijenda.recipes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gehazijenda.recipes.data.models.Category
import com.gehazijenda.recipes.ui.screens.CategoryDetailsScreen
import com.gehazijenda.recipes.ui.screens.HomeScreen
import com.gehazijenda.recipes.ui.screens.Screen
import com.gehazijenda.recipes.ui.viewmodels.CategoriesViewModel
import com.gehazijenda.recipes.ui.viewmodels.RegionsViewModel

@Composable
fun RecipeApp(navHostController: NavHostController) {
    //init view model for categories
    val categoriesViewModel: CategoriesViewModel = viewModel()
    val categoriesState by categoriesViewModel.categoriesState

    //init view model for regions
    val regionsViewModel: RegionsViewModel = viewModel()
    val regionsState by regionsViewModel.regionsState

    NavHost(navController = navHostController, startDestination = Screen.HomeScreen.route) {
        //home screen, housing the tab bar
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(
                categoriesState,
                regionsState,
                navigateToDetails = {
                    navHostController.currentBackStackEntry?.savedStateHandle?.set(
                        "category", it
                    )
                    navHostController.navigate(Screen.CategoryDetailsScreen.route)
                }
            )
        }
        
        //category details screen
        composable(
            route = Screen.CategoryDetailsScreen.route
        ) {
            val category =
                navHostController.previousBackStackEntry?.savedStateHandle?.get<Category>("category")
                    ?:
                    Category("", "", "", "")
            CategoryDetailsScreen(category)
        }

    }
}