package com.gehazijenda.recipes.ui.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.gehazijenda.recipes.data.constants.AppColors
import com.gehazijenda.recipes.data.model.Category

@Composable
fun CategoryItem(category: Category, modifier: Modifier = Modifier) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(190.dp)
            .width(150.dp)
            .shadow(4.dp,
                shape = RoundedCornerShape(20.dp),
                ambientColor = AppColors.appBarGrey)
            .background(
                color = AppColors.cardBgGrey,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.End)
                ) {
                Icon(
                    Icons.Filled.Info,
                    contentDescription = "Category Info",
                    tint = AppColors.primaryOrange
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = rememberAsyncImagePainter(category.strCategoryThumb),
                contentDescription = category.strCategory,
                modifier = Modifier
                    .height(80.dp)
                    .wrapContentWidth()
                )

            Spacer(modifier = Modifier.height(10.dp). fillMaxWidth())

            TextComponent(
                text = category.strCategory,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                )

            Spacer(modifier = Modifier.height(10.dp). fillMaxWidth())

        }
    }
}

@Preview
@Composable
fun CategoryItemPreview() {
    CategoryItem(
        category = Category(
        idCategory = "1",
        strCategory = "Beef",
        strCategoryThumb =  "https:\\/\\/www.themealdb.com\\/images\\/category\\/beef.png",
        ""
    ))
}
