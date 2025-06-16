package com.vpdevs.uninotes

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vpdevs.uninotes.app.screens.AddNotesScreen
import com.vpdevs.uninotes.app.screens.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen() {
                navController.navigate("AddNotes")
            }
        }
        composable("AddNotes") {
            AddNotesScreen(
                onBackButtonClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}
