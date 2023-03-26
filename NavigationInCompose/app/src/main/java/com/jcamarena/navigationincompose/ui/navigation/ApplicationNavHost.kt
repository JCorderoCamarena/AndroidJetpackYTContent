package com.jcamarena.navigationincompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jcamarena.navigationincompose.ui.navigation.navgraph.addAuthNavigationGraph
import com.jcamarena.navigationincompose.ui.navigation.navgraph.addAuthenticatedNavGraph
import com.jcamarena.navigationincompose.ui.navigation.navgraph.addSplashRoute

@Composable
fun ApplicationNavHost(
    navController: NavHostController
) {
    var authenticated by rememberSaveable { mutableStateOf(false) }

    NavHost(navController = navController, startDestination = Routes.Root.route) {
        addSplashRoute {
            navController.popBackStack()
            navController.navigate(
                if (authenticated) Routes.Authenticated.route else Routes.SignIn.route
            )
        }

        addAuthNavigationGraph(
            onLoginPressed = {
                authenticated = true
                navController.popBackStack()
                navController.navigate(Routes.Authenticated.route)
            },
            onNavigateToSignUp = {
                navController.navigate(Routes.SignUp.route)
            },
            onUserRegistered = {
                navController.popBackStack()
            }
        )


        addAuthenticatedNavGraph {
            authenticated = false
            navController.popBackStack(Routes.Home.route, inclusive = true)
            navController.navigate(Routes.SignIn.route)
        }
    }
}