package com.jcamarena.navigationincompose.ui.navigation.navgraph

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.jcamarena.navigationincompose.ui.navigation.Routes
import com.jcamarena.navigationincompose.ui.presentation.screens.splash.SplashScreen
import kotlinx.coroutines.delay

fun NavGraphBuilder.addSplashRoute(
    onSplashFinished: () -> Unit
) {
    composable(
        route = Routes.Root.route,
        deepLinks = listOf( navDeepLink { uriPattern = "https://www.test.com" })
    ) {
        LaunchedEffect(key1 = true) {
            delay(1000)
            onSplashFinished()
        }

        SplashScreen()
    }
}