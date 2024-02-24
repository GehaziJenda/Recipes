package com.gehazijenda.recipes.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.gehazijenda.recipes.data.constants.AppColors
import com.gehazijenda.recipes.data.constants.Fonts

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    text: String,
    size: TextUnit? = 16.sp,
    color: Color? = AppColors.textGrey,
    fontWeight: FontWeight? = FontWeight.Normal,

) {
    Text(
        text = text,
        modifier = modifier,
        fontFamily = Fonts.robotoMonoFamily,
        style = TextStyle(
            fontSize = size ?: 16.sp,
            color = color ?: AppColors.textGrey,
            fontWeight = fontWeight
        )
    )
}