package com.gehazijenda.recipes.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Region(val strArea: String) : Parcelable

data class RegionsResponse(val meals: List<Region>)
