package com.dongguk.finalexam.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController, viewModel: UserInputViewModel) {
    NavHost(
        navController = navController,
        startDestination = "inputScreen" // 첫 화면 설정
    ) {
        // 입력 화면
        composable("inputScreen") {
            InputScreen(
                viewModel = viewModel,
                onNavigateToDisplay = { navController.navigate("displayScreen") }
            )
        }
        // 출력 화면
        composable("displayScreen") {
            DisplayScreen(viewModel = viewModel)
        }
    }
}
