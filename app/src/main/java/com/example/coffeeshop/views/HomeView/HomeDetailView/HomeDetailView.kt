package com.example.coffeeshop.views.HomeView.HomeDetailView

import android.util.Log
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeeshop.views.HomeView.HomeDetailView.DetailSubViews.ButtonsDetailView
import com.example.coffeeshop.views.HomeView.HomeDetailView.DetailSubViews.DetailDescriptionView
import com.example.coffeeshop.views.HomeView.HomeDetailView.DetailSubViews.ImageDetailView

@Composable
fun HomeDetailView(
    productId: String,
    imageUrl: String,
    name: String,
//    onBackClick: () -> Unit= {},
    productDescription: String,
    price: Double,
    region: String,
    roastLevel: Int,
    isLiked: Boolean,
    navController: NavController,
    onLikeClick: () -> Unit = {}
//    gridOptions: List<String>
) {

    Log.d("HomeDetailView", "ProductId: $productId, ImageUrl: $imageUrl, Name: $name")
    Log.d("HomeDetailView", "Description: $productDescription, Price: $price, Region: $region, RoastLevel: $roastLevel")
    
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp)
            .padding(end = 8.dp)
    ) {


        ImageDetailView(imageUrl = imageUrl, isLiked = isLiked, onLikeClick = onLikeClick , navController = navController)


        DetailDescriptionView(
            name = name,
            description = productDescription,
            price = price,
            region = region,
            roastLevel = roastLevel,
//            gridOptions = gridOptions
        )

    }
}