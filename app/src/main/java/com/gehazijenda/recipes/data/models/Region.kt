package com.gehazijenda.recipes.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Region(val strArea: String) : Parcelable

data class RegionsResponse(val meals: List<Region>)
