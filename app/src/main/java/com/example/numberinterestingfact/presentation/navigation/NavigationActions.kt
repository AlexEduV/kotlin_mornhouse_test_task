package com.example.numberinterestingfact.presentation.navigation

import androidx.navigation.NavController

fun NavController.navigateToFactDetails(number: String, fact: String) {
    navigate("${Destinations.FactDetails.route}/$number/$fact")
}