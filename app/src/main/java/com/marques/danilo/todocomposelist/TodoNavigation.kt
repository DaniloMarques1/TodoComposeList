package com.marques.danilo.todocomposelist

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marques.danilo.todocomposelist.Destinations.HOME
import com.marques.danilo.todocomposelist.view.HomeRoute

object Destinations {
    const val HOME = "home"
}

@Composable
fun TodoNavHost(navHostController: NavHostController = rememberNavController()) {
    NavHost(navController = navHostController, startDestination = HOME) {
        composable(HOME) {
            HomeRoute()
        }
    }
}