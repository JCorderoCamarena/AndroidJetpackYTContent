package com.jcamarena.navigationincompose.ui.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jcamarena.navigationincompose.ui.navigation.Routes
import com.jcamarena.navigationincompose.ui.presentation.screens.home.HomeGreetingScreen
import com.jcamarena.navigationincompose.ui.presentation.screens.home.HomeScreen


fun NavGraphBuilder.addHomeRoutes(
    onLogoutPressed: () -> Unit,
    onNavigateToGreetingScreen: (String) -> Unit
) {
    composable(route = Routes.Home.route) {
        HomeScreen(onLogoutPressed = onLogoutPressed, onNavigateToGreeting = onNavigateToGreetingScreen)
    }

    composable(route = "${Routes.HomeGreeting.route}/{name}") {
        HomeGreetingScreen(name = it.arguments?.getString("name") ?: "")
    }
}