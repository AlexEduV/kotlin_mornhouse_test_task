package com.example.numberinterestingfact.presentation.navigation

sealed class Destinations(val route: String) {
    data object Home : Destinations("home")
    data object FactDetails : Destinations("factDetails")
}