package com.andikas.animu.ui.navigation

import com.andikas.animu.ui.common.AnimeType

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail/{detailId}/{animeId}/{type}") {
        fun createRoute(
            detailId: String,
            animeId: Long,
            type: String,
        ) = "detail/$detailId/$animeId/$type"
    }
}
