package com.example.numberinterestingfact.presentation.screens.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.numberinterestingfact.presentation.screens.home_screen.compose.HistoryListView
import com.example.numberinterestingfact.presentation.screens.home_screen.compose.SimpleOutlinedTextField
import com.example.numberinterestingfact.data.AppDatabase
import com.example.numberinterestingfact.data.NumberModel
import com.example.numberinterestingfact.domain.repositories.fetchData
import com.example.numberinterestingfact.domain.models.HistoryEntry
import com.example.numberinterestingfact.presentation.theme.NumberInterestingFactTheme
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

@Composable
fun HomeScreen(navHostController: NavHostController, database: AppDatabase) {

    val entries = remember { mutableStateListOf<HistoryEntry>() }

    var enteredNumber by remember { mutableStateOf("") }
    var enteredTextError by remember { mutableStateOf("") }

    //get init entries
    suspend fun initDatabase() {
        val dao = database.numberDao()
        val history = dao.getAll()

        entries.clear()

        history.forEach { historyEntry ->
            entries.add(HistoryEntry(historyEntry.number, historyEntry.fact))
        }
    }

    fun validateTextField() {

        enteredTextError = when {
            enteredNumber.isEmpty() -> {
                "The field is empty."
            }
            enteredNumber.length > 10 -> {
                "The number is too long"
            }
            else -> {
                ""
            }
        }
    }

    fun addFactEntry(number: String) {

        //fetch a fact, based on the input
        runBlocking {
            launch {
                val fact: String = fetchData(number = number)

                //update database
                val dao = database.numberDao()
                dao.insertAll(NumberModel(
                    number = number,
                    fact = fact,
                ))

                //update list view
                entries.add(HistoryEntry(number, fact))

                //clear the textField
                enteredNumber = ""
            }
        }
    }

    fun getFactOfNumber() {

        //validate input
        validateTextField()

        if (enteredTextError.isEmpty()) {

            addFactEntry(enteredNumber)
        }

    }

    fun getFactOfRandomNumber() {

        //get random number
        val randomNumber: Int = Random.nextInt(0, 100)
        addFactEntry(randomNumber.toString())

    }

    runBlocking {
        launch {
            initDatabase()
        }
    }

    NumberInterestingFactTheme {
        Scaffold(
            modifier = Modifier
                .padding(top = 48.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                .fillMaxSize(),

            ) { innerPadding ->

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(bottom = innerPadding.calculateBottomPadding()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //text field
                SimpleOutlinedTextField(
                    text = enteredNumber,
                    onValueChange = { enteredNumber = it },
                    errorMessage = enteredTextError,
                )

                Spacer(Modifier.height(12.dp))

                //buttons row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {

                    Button(onClick = { getFactOfNumber() }) {
                        Text("Get fact")
                    }

                    Button(onClick = { getFactOfRandomNumber() }) {
                        Text("Get fact about a random number")
                    }

                }

                Spacer(Modifier.height(32.dp))

                //history listView
                HistoryListView(
                    entries = entries,
                    navHostController = navHostController,
                )



            }

        }
    }
}