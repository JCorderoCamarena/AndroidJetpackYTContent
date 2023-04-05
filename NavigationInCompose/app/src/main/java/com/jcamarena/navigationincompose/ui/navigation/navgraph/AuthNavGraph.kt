package com.jcamarena.navigationincompose.ui.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jcamarena.navigationincompose.ui.navigation.Routes
import com.jcamarena.navigationincompose.ui.presentation.screens.signin.SignInScreen
import com.jcamarena.navigationincompose.ui.presentation.screens.signup.SignUpScreen


fun NavGraphBuilder.addAuthNavigationGraph(
    onLoginPressed: () -> Unit,
    onNavigateToSignUp: () -> Unit,
    onUserRegistered: () -> Unit,
) {
    navigation(startDestination = Routes.SignIn.route, route = Routes.AuthNavGraph.route) {
        composable(route = Routes.SignIn.route) {
            SignInScreen(onLoginPressed = onLoginPressed, onNavigateToSignUp = onNavigateToSignUp)
        }

        composable(route = Routes.SignUp.route) {
            SignUpScreen(onUserRegistered = onUserRegistered)
        }
    }
}