package com.example.coffeeshop.views.HomeView.HomeDetailView.DetailSubViews

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon (
                  imageVector = Icons.Default.LocationOn,
                    contentDescription = "Region",
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = region,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Roast level: ${roastLevel.toString()}")
        }

        Text(
            text = productDescription,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}