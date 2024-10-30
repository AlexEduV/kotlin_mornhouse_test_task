package com.example.numberinterestingfact.presentation.screens.fact_details_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.numberinterestingfact.presentation.common.BackButton

@Composable
fun FactDetailsScreen(
    navHostController: NavHostController,
    number: String?,
    fact: String?,
) {

    Column(modifier = Modifier
        .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)) {

        //Back Button
        BackButton {
            navHostController.popBackStack()
        }

        //Centered number
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                number ?: "Error",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(Modifier.height(12.dp))

            Text(
                fact ?: "No Fact Found",
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                textAlign = TextAlign.Center,
            )

        }

    }

}