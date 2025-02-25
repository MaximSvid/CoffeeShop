package com.example.coffeeshop.views.HomeView.HomeDetailView.DetailSubViews

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ImageDetailView (
    imageUrl: String,
    onLikeClick: () -> Unit
) {
   Box (
       modifier = Modifier
           .fillMaxWidth()
           .height(200.dp)
           .padding(start = 5.dp)
           .padding(end = 5.dp)
   ){

       AsyncImage(
           model = imageUrl,
           contentDescription = "coffee1",
           modifier = Modifier
               .fillMaxSize()
       )

       IconButton(
           onClick = onLikeClick,
           modifier = Modifier
               .align(Alignment.TopEnd)
               .padding(8.dp)
           ) {

           Icon (
              imageVector = Icons.Default.Favorite,
               contentDescription = "Like",
               tint = Color.White
           )
       }
   }
}

@Preview
@Composable
fun ImageDetailPreview() {
    ImageDetailView(imageUrl = "https://picsum.photos/200",
        onLikeClick = {}
    )
}