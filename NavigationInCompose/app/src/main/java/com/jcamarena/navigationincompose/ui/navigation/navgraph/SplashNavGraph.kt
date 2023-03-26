package com.jcamarena.navigationincompose.ui.navigation.navgraph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jcamarena.navigationincompose.ui.navigation.Routes
import kotlinx.coroutines.delay

fun NavGraphBuilder.addSplashRoute(
    onSplashFinished: () -> Unit
) {
    composable(route = Routes.Root.route) {
        LaunchedEffect(key1 = true) {
            delay(1000)
            onSplashFinished()
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                CircularProgressIndicator()
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Loading...")
            }
        }
    }
}