package com.example.coffeeshop.data.model

import com.example.coffeeshop.data.enumClass.SortType

data class SearchState (
    val searchText: String = "",
    val sortType: SortType = SortType.NAME_ASC,
    val active: Boolean = false
)