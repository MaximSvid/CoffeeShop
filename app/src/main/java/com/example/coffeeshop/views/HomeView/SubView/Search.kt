package com.example.coffeeshop.views.HomeView.SubView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coffeeshop.data.enumClass.SortType
import com.example.coffeeshop.data.model.SearchState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    state: SearchState,
    onStateChange: (SearchState) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        SearchBar(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(max = 80.dp), //fehler...
            query = state.searchText,
            onQueryChange = { onStateChange(state.copy(searchText = it)) },
            onSearch = { onStateChange(state.copy(active = false)) },
            active = state.active,
            onActiveChange = { onStateChange(state.copy(active = it)) },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "search")
            },
            trailingIcon = {
                if (state.active && state.searchText.isNotEmpty()) {
                    IconButton(onClick = {
                        onStateChange(state.copy(searchText = ""))
                    }) {
                        Icon(Icons.Default.Close, contentDescription = "Clear")
                    }
                }
            }
        ) {

        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            SortChip(
                selected = state.sortType == SortType.NAME_ASC,
                onClick = { onStateChange(state.copy(sortType = SortType.NAME_ASC)) },
                label = "Name ↑"
            )

            SortChip(
                selected = state.sortType == SortType.NAME_DESC,
                onClick = { onStateChange(state.copy(sortType = SortType.NAME_DESC)) },
                label = "Name ↓"
            )

            SortChip(
                selected = state.sortType == SortType.PRICE_ASC,
                onClick = { onStateChange(state.copy(sortType = SortType.PRICE_ASC)) },
                label = "Price ↑"
            )

            SortChip(
                selected = state.sortType == SortType.PRICE_DESC,
                onClick = { onStateChange(state.copy(sortType = SortType.PRICE_DESC)) },
                label = "Price ↓"
            )
        }
    }
}

