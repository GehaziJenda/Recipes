package com.gehazijenda.recipes.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.gehazijenda.recipes.data.models.Category
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.gehazijenda.recipes.R
import com.gehazijenda.recipes.data.constants.AppColors
import com.gehazijenda.recipes.ui.components.TextComponent


@Composable
fun CategoryDetailsScreen(category: Category) {
    Column {
        //box for the top part
        Box {
            //image of category
            Image(painter = rememberAsyncImagePainter(category.strCategoryThumb),
                contentDescription = category.strCategory,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            //box for category name
            Box(
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .background(
                        color = Color.Black.copy(
                            alpha = 0.4f
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(vertical = 15.dp, horizontal = 35.dp)
                    .align(Alignment.BottomEnd)
            ) {
                TextComponent(
                    text = category.strCategory,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            //back icon
            Box(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 15.dp)
                    .size(55.dp)
                    .shadow(2.dp, shape = CircleShape, ambientColor = AppColors.appBarGrey)
                    .background(
                        color = AppColors.cardBgGrey,
                        shape = CircleShape
                    )
                    .align(Alignment.TopStart)
                    .clickable {

                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Back",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        TextComponent(
            text = category.strCategoryDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 10.dp)
        )
    }
}