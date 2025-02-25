package com.example.coffeeshop.views.HomeView.HomeDetailView.DetailSubViews

import androidx.compose.foundation.background
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun ImageDetailView (
    imageUrl: String,
    isLiked: Boolean,
    onLikeClick: () -> Unit,
//    onBackClick: () -> Unit
    navController: NavController
) {
   Box (
       modifier = Modifier
           .fillMaxWidth()
           .height(300.dp)
           .padding(start = 8.dp)
           .padding(end = 8.dp)
           .shadow(3.dp)
           .background(
               color = MaterialTheme.colorScheme.surface,
               shape = RoundedCornerShape(6.dp)
           )

   ){

       AsyncImage(
           model = imageUrl,
           contentDescription = "coffee1",
           modifier = Modifier
               .fillMaxSize()
       )

       IconButton(
           onClick = { navController.popBackStack() },
           modifier = Modifier.align(Alignment.TopStart)
       ) {
           Icon(
               imageVector = Icons.AutoMirrored.Filled.ArrowBack,
               contentDescription = "Back"
           )
       }

       IconButton(
           onClick = onLikeClick,
           modifier = Modifier
               .align(Alignment.TopEnd)
//               .padding(8.dp)
           ) {

           Icon (
               imageVector = if (isLiked) {
                   Icons.Filled.Favorite
               } else {
                   Icons.Default.FavoriteBorder
               },
               contentDescription = if (isLiked) "Unlike" else "Like",
               tint = Color.Red
           )
       }
   }
}
