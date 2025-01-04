package com.example.numberinterestingfact.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun AppBarButton(imageVector: ImageVector, contentDescription: String, onClick: () -> Unit) {

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .background(Color.White.copy(alpha = 0.9f))
            .padding(all = 8.dp)
    ) {

        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
        )
    }

}

@Composable
fun BackButton(onClick: () -> Unit) {

    AppBarButton(
        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
        contentDescription = "Back",
        onClick = onClick
    )
}