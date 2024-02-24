package com.gehazijenda.recipes.data.constants

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.gehazijenda.recipes.R

class Fonts {
    companion object{
        val robotoMonoFamily = FontFamily(
            Font(R.font.roboto_mono_light, FontWeight.Light),
            Font(R.font.roboto_mono_regular, FontWeight.Normal),
            Font(R.font.roboto_mono_medium, FontWeight.Medium),
            Font(R.font.roboto_mono_bold, FontWeight.Bold)
        )
    }
}