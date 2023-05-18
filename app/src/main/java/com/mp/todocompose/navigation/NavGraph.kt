package com.mp.todocompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mp.todocompose.ui.screen.home.HomeScreen
import com.mp.todocompose.ui.screen.item.ItemDialog

@Composable
fun TodoNavGraph(
    modifier: Modifier = Modifier
) {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.HOME_SCREEN) {
        composable(Destinations.HOME_SCREEN) {
            HomeScreen(
                onNavAddItem = {
                    navController.navigate(Destinations.DIALOG_ITEM)
                },
                onNavToItem = {
                    navController.navigate(Destinations.ITEM_CARD)
                }
            )
        }
        composable(Destinations.DIALOG_ITEM) {
            ItemDialog(
                onNavBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}