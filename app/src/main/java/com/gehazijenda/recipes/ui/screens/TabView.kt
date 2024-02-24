package com.gehazijenda.recipes.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gehazijenda.recipes.data.constants.AppColors
import com.gehazijenda.recipes.ui.components.TextComponent
import com.gehazijenda.recipes.ui.viewmodels.CategoriesViewModel

@Composable
fun TabView(categoriesViewState : CategoriesViewModel.CategoriesStateClass) {
    val tabs = listOf("Categories", "Regions")
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column {
        //this creates the tabs at the top
        TabRow(
            selectedTabIndex = selectedTabIndex,
            backgroundColor = AppColors.appBarGrey,
            contentColor = Color.Black,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    color = AppColors.primaryOrange, // Change indicator color as needed
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .padding(horizontal = 20.dp)
                )
            },
            divider = {
                TabRowDefaults.Divider(
                    color = Color.Transparent
                )
            }
            ) {
            tabs.forEachIndexed{
                index: Int,
                title: String -> Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = { TextComponent(
                        text = title,
                        color = if (selectedTabIndex == index)
                         AppColors.primaryOrange else Color.Black,
                        size = 14.sp
                        ) }
                )
            }
        }
        Box(modifier = Modifier.background(color = AppColors.appBarGrey).fillMaxWidth().height(10.dp))
        //display the content based on selected tab
        when (selectedTabIndex) {
            0 -> CategoriesScreen(categoriesViewState)
            1 -> RegionsScreen()
        }
    }
}