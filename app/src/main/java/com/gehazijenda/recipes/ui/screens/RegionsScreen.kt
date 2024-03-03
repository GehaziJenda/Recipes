package com.gehazijenda.recipes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gehazijenda.recipes.data.models.Region
import com.gehazijenda.recipes.ui.components.RegionItem
import com.gehazijenda.recipes.ui.components.TextComponent
import com.gehazijenda.recipes.ui.viewmodels.RegionsViewModel

@Composable
fun RegionsScreen(
    viewState: RegionsViewModel.RegionsStateClass
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp)
    ) {
        when {
            //when loading
            viewState.loading -> {
                CircularProgressIndicator(
                    Modifier.align(
                        Alignment.Center
                    )
                )
            }

            //when there is an error
            viewState.error != null -> {
                TextComponent(text = viewState.error)
            }

            //when we get the regions
            else -> {
                RegionsList(list = viewState.list)
            }
        }
    }
}

@Composable
fun RegionsList(list: List<Region>) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(list) {
            region -> RegionItem(region = region)
        }
    }
}