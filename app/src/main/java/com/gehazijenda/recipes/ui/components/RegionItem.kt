package com.gehazijenda.recipes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gehazijenda.recipes.R
import com.gehazijenda.recipes.data.constants.AppColors
import com.gehazijenda.recipes.data.models.Region

@Composable
fun RegionItem(region: Region) {
    Box(
        Modifier.fillMaxWidth()
            .shadow(4.dp,
                shape = RoundedCornerShape(5.dp),
                ambientColor = AppColors.appBarGrey)
            .background(
                color = AppColors.cardBgGrey,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(vertical = 18.dp, horizontal = 15.dp),
        contentAlignment = Alignment.CenterStart,

    ) {
        Row {
            Icon(painter = painterResource(R.drawable.world_icon),
                contentDescription = "Icon",
                tint = AppColors.primaryOrange)
            Spacer(modifier = Modifier.width(20.dp))
            TextComponent(text = region.strArea, color = Color.Black)
        }
    }
}