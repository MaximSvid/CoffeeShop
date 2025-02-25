package com.example.coffeeshop.views.HomeView.HomeDetailView.DetailSubViews

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier

@SuppressLint("DefaultLocale")
@Composable
fun DetailDescriptionView (
    name: String,
    productDescription: String,
    price: Double,
    region: String,
    roastLevel: Int,
    gridOptions: List<String>,
    modifier: Modifier = Modifier

) {

    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Text(
                text = name,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .weight(1f)
            )

            Text(
                text = "$${String.format("%.2f", price)}",
                style = MaterialTheme.typography.headlineLarge
            )

        }

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row (

            ){

            }
            Text(text = region)

            Text(text = roastLevel.toString())
        }

        Text(text = productDescription)
    }
}