package com.jcamarena.navigationincompose.ui.navigation.navgraph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jcamarena.navigationincompose.ui.navigation.Routes


fun NavGraphBuilder.addAuthNavigationGraph(
    onLoginPressed: () -> Unit,
    onNavigateToSignUp: () -> Unit,
    onUserRegistered: () -> Unit,
) {
    navigation(startDestination = Routes.SignIn.route, route = Routes.AuthNavGraph.route) {
        composable(route = Routes.SignIn.route) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Button(onClick = onLoginPressed) {
                        Text(text = "Log me in!")
                    }
                    Button(onClick = onNavigateToSignUp) {
                        Text(text = "Go to Sign Up")
                    }
                }
            }
        }

        composable(route = Routes.SignUp.route) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = onUserRegistered) {
                    Text(text = "Create user!")
                }
            }
        }
    }
}