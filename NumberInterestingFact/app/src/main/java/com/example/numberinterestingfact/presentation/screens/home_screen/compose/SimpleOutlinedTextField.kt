package com.example.numberinterestingfact.presentation.screens.home_screen.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun SimpleOutlinedTextField(
    text: String,
    onValueChange: (String) -> Unit,
    errorMessage: String
    ) {

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = onValueChange,
        label = { Text("Enter a Number") },
        isError = errorMessage.isNotEmpty(),
        supportingText = {
            if (errorMessage.isNotEmpty()) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}