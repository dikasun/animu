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
                navigateToDetail = { detailId, animeId, animeType ->
                    navController.navigate(Screen.Detail.createRoute(detailId, animeId, animeType))
                }
            )
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("detailId") { type = NavType.StringType },
                navArgument("animeId") { type = NavType.LongType },
                navArgument("type") { type = NavType.StringType }
            )
        ) {
            val detailId = it.arguments?.getString("detailId") ?: ""
            val animeId = it.arguments?.getLong("animeId") ?: -1L
            val animeType = it.arguments?.getString("type") ?: ""

            DetailScreen(
                id = animeId,
                animeId = detailId,
                animeType = animeType,
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
        Animu()
    }
}