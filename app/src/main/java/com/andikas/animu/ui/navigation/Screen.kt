package com.andikas.animu.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail/{detailId}/{animeId}/{type}/{favorite}") {
        fun createRoute(
            detailId: String,
            animeId: Long,
            type: String,
            favorite: Boolean,
        ) = "detail/$detailId/$animeId/$type/$favorite"
    }
}
