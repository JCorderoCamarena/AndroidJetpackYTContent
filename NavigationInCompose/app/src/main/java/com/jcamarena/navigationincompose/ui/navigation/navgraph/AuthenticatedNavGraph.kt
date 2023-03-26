package com.jcamarena.navigationincompose.ui.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jcamarena.navigationincompose.ui.navigation.Routes
import com.jcamarena.navigationincompose.ui.presentation.widgets.AuthenticatedScreen

fun NavGraphBuilder.addAuthenticatedNavGraph(
    onLogoutPressed: () -> Unit
) {
    navigation(startDestination = Routes.Home.route, route = Routes.Authenticated.route) {
        composable(route = Routes.Home.route) {
            AuthenticatedScreen(label = "Home", onLogoutPressed = onLogoutPressed)
        }
        composable(route = Routes.Profile.route) {
            AuthenticatedScreen(label = "Profile", onLogoutPressed = onLogoutPressed)
        }
        composable(route = Routes.Settings.route) {
            AuthenticatedScreen(label = "Settings", onLogoutPressed = onLogoutPressed)
        }
    }
}