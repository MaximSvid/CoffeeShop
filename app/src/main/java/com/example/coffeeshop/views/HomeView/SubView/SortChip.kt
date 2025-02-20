package com.example.coffeeshop.views.HomeView.SubView

import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//@OptIn(ExperimentalMaterial3Api)
@Composable
fun SortChip(
    selected: Boolean,
    onClick: () -> Unit,
    label: String
) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        label = { Text(label) },
        modifier = Modifier.height(28.dp)
    )
}