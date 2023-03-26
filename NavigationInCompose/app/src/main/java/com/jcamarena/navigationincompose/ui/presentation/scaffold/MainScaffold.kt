package com.jcamarena.navigationincompose.ui.presentation.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jcamarena.navigationincompose.ui.navigation.ApplicationNavHost
import com.jcamarena.navigationincompose.ui.presentation.bottomnavigation.BottomNavigation
import com.jcamarena.navigationincompose.ui.presentation.bottomnavigation.bottomBarVisibility

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            BottomNavigation(
                navController = navController,
                state = bottomBarVisibility(navController = navController)
            )
        },
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            ApplicationNavHost(navController = navController)
        }
    }
}