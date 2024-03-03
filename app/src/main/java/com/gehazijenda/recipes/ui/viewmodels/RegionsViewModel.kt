package com.gehazijenda.recipes.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gehazijenda.recipes.data.api.recipeService
import com.gehazijenda.recipes.data.models.Region
import kotlinx.coroutines.launch

class RegionsViewModel: ViewModel() {

    //region state that is observed by the view model
    private val _regionState = mutableStateOf(
        RegionsStateClass()
    )

    //region state exposed to the UI
    val regionsState : State<RegionsStateClass> = _regionState

    //call fetch regions upon initialization
    init {
        fetchRegions()
    }

    //function to fetch the regions
    private fun fetchRegions() {
        viewModelScope.launch {
            //try get the region and catch any exceptions
            try {
                //get data from API
                val response = recipeService.getRegions()
                _regionState.value = _regionState.value.copy(
                    loading = false,
                    list = response.meals,
                    error = null
                )
            } catch (e: Exception) {
                _regionState.value = _regionState.value.copy(
                    loading = false,
                    error = "Error fetching regions : ${e.message}"
                )
            }
        }
    }

    //class to keep the state of the region api call
    data class RegionsStateClass(
        val loading : Boolean = true,
        val list: List<Region> = emptyList(),
        val error: String? = null
    )
}