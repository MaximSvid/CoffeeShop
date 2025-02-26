package com.example.coffeeshop.views.HomeView.HomeDetailView.DetailSubViews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeshop.ui.theme.BrownJC

@Composable
fun ButtonsDetailView(
    onClickBuyNow: () -> Unit,
    onClickCart: () -> Unit,
    modifier: Modifier
) {
    Row (
    modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Button(
          onClick = { /*TODO*/ },
          modifier = modifier
              .weight(1f),
//              .padding(16.dp),
          shape = RoundedCornerShape(6.dp),
          colors = ButtonDefaults.buttonColors(
              containerColor = BrownJC,
              contentColor = Color.White
          )
      ) {
          Text(text = "Buy Now")
      }

        Button(
            onClick = { /*TODO*/ },
            modifier = modifier
            .padding(start = 8.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = BrownJC,
                contentColor = Color.White
            )
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Cart"
            )
        }
    }
}
