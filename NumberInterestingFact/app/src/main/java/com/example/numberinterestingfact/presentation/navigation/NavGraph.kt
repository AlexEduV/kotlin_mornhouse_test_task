package com.example.numberinterestingfact.presentation.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.compose.composable
import com.example.numberinterestingfact.data.AppDatabase
import com.example.numberinterestingfact.presentation.screens.fact_details_screen.FactDetailsScreen
import com.example.numberinterestingfact.presentation.screens.home_screen.HomeScreen

@Composable
fun NavGraph(navController: NavHostController, database: AppDatabase) {

    MaterialTheme {

        NavHost(
            navController = navController,
            startDestination = Destinations.Home.route
        ) {
            composable(Destinations.Home.route) {
                HomeScreen(navController, database)
            }
            composable(
                route = "${Destinations.FactDetails.route}/{number}/{fact}",
                arguments = listOf(
                    navArgument("number") { type = NavType.StringType },
                    navArgument("fact") { type = NavType.StringType },
                )
            ) { backStackEntry ->

                val number = backStackEntry.arguments?.getString("number")
                val fact = backStackEntry.arguments?.getString("fact")
                FactDetailsScreen(navController, number = number, fact = fact)
            }
        }
    }
}
