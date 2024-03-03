package com.gehazijenda.recipes.ui.screens


//sealed classes are used to define a closed set of subclasses
//this allows us to define a restricted class hierarchy in which subclasses are finite and predetermined
//setting our routes this way allows us to ensure we don't make a mistake when calling a screen
sealed class Screen(val route: String) {
    data object HomeScreen: Screen("homeScreen")

//    data object CategoriesScreen: Screen("categoriesScreen")
//    data object RegionsScreen: Screen("regionsScreen")
    data object CategoryDetailsScreen : Screen("categoryDetailsScreen")
}