package com.jcamarena.navigationincompose.ui.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jcamarena.navigationincompose.ui.navigation.Routes
import com.jcamarena.navigationincompose.ui.navigation.navigateToGreetingScreen
import com.jcamarena.navigationincompose.ui.presentation.screens.profile.ProfileScreen
import com.jcamarena.navigationincompose.ui.presentation.screens.settings.SettingsScreen

fun NavGraphBuilder.addAuthenticatedNavGraph(
    navController: NavHostController,
    onLogoutPressed: () -> Unit
) {
    navigation(startDestination = Routes.Home.route, route = Routes.Authenticated.route) {
        addHomeRoutes(
            onLogoutPressed = onLogoutPressed,
            onNavigateToGreetingScreen = {
                navController.navigateToGreetingScreen(it)
            }
        )

        composable(route = Routes.Profile.route) {
            ProfileScreen(onLogoutPressed = onLogoutPressed)
        }
        composable(route = Routes.Settings.route) {
            SettingsScreen(onLogoutPressed = onLogoutPressed)
        }
    }
}