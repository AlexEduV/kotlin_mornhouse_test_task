package com.example.numberinterestingfact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.numberinterestingfact.data.AppDatabase
import com.example.numberinterestingfact.presentation.navigation.NavGraph

class MainActivity : ComponentActivity() {

    //todo: maybe should disable buttons, while the previous request is processing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //init database
        val database: AppDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        //init navigation, starting with the Home Screen
        setContent {
            val navController = rememberNavController()
            NavGraph(navController = navController, database = database)
        }
    }
}

