package com.example.numberinterestingfact.presentation.screens.home_screen.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.numberinterestingfact.domain.models.HistoryEntry
import com.example.numberinterestingfact.presentation.navigation.navigateToFactDetails

@Composable
fun HistoryListView(
    entries: List<HistoryEntry>,
    navHostController: NavHostController
) {

    Column(Modifier
        .verticalScroll(rememberScrollState())
    ) {
        entries.forEach { entry ->

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clickable(onClick = {

                    navHostController.navigateToFactDetails(
                        number = entry.number,
                        fact = entry.fact,
                    )

                })
            ) {

                Box(modifier = Modifier.width(35.dp)) {
                    Text(
                        entry.number,
                        fontSize = 18.sp,
                    )
                }

                Spacer(Modifier.width(16.dp))

                Text(
                    entry.fact,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 18.sp,
                )

            }
        }
    }

}