package com.andikas.animu.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.andikas.animu.ui.navigation.Screen
import com.andikas.animu.ui.screen.detail.DetailScreen
import com.andikas.animu.ui.screen.home.HomeScreen
import com.andikas.animu.ui.theme.AnimuTheme

@Composable
fun Animu(
    navigateToFavorite: () -> Unit,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier,
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                navigateToFavorite = navigateToFavorite,
                navigateToDetail = { detailId, animeId, animeType, favorite ->
                    navController.navigate(
                        Screen.Detail.createRoute(
                            detailId,
                            animeId,
                            animeType,
                            favorite
                        )
                    )
                },
            )
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("detailId") { type = NavType.StringType },
                navArgument("animeId") { type = NavType.LongType },
                navArgument("type") { type = NavType.StringType },
                navArgument("favorite") { type = NavType.BoolType }
            )
        ) {
            val detailId = it.arguments?.getString("detailId") ?: ""
            val animeId = it.arguments?.getLong("animeId") ?: -1L
            val animeType = it.arguments?.getString("type") ?: ""
            val favorite = it.arguments?.getBoolean("favorite") ?: false

            DetailScreen(
                id = animeId,
                animeId = detailId,
                animeType = animeType,
                favorite = favorite,
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    device = Devices.PIXEL_4_XL,
)
@Composable
fun AnimuPreview() {
    AnimuTheme {
        Animu(navigateToFavorite = {})
    }
}