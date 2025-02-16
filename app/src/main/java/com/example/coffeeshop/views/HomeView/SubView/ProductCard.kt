package com.example.coffeeshop.views.HomeView.SubView

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.R


@SuppressLint("DefaultLocale")
@Composable
fun ProductCard (
    painter: Painter,
    contentDescription:String,
    title: String,
    roastLevel: Int,
    price: Double,
    onLikeClick: () -> Unit,
    isLiked: Boolean = false,
    modifier: Modifier
) {
    Card (
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(5.dp)
    ) {
        Box (
            modifier = Modifier.height(200.dp)
        ) {
          Image(
              painter = painter,
              contentDescription = contentDescription,
              modifier = Modifier.fillMaxSize(),
              contentScale = ContentScale.Crop
              )
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )

            IconButton(
                onClick = onLikeClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = "Like",
                    tint = if (isLiked) Color.Red else Color.White
                )
            }
            //content container
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.Bottom
            ){
                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Roast Level",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    )
                    Text(
                        text = roastLevel.toString(),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Text(
                    text = String.format("%.2f", price),
                    style = TextStyle(
                        color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                )
            }
        }
    }
}

@Preview
@Composable
fun ProductCardPreview () {

    val painter = painterResource(id = R.drawable.coffee2)
    val description = "Test description"
    val title = "Test title"
    val roastLevel = 3
    val price = 12.99
    ProductCard(
        painter = painter,
        contentDescription = description,
        title = title,
        roastLevel = roastLevel,
        price = price,
        onLikeClick = { /*TODO*/ },
        modifier = Modifier
    )
}