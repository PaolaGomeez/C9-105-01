package com.example.c9_105_01.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun SoundInNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = SoundInRoutes.LOGIN
    ) {

    }
}