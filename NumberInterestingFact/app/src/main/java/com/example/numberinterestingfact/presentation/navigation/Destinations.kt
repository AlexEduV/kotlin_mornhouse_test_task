package com.example.numberinterestingfact.presentation.navigation

sealed class Destinations(val route: String) {
    object Home : Destinations("home")
    object FactDetails : Destinations("factDetails")
}