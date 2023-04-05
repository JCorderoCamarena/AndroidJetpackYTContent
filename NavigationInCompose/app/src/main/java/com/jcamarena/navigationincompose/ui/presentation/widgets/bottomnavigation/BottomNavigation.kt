package com.jcamarena.navigationincompose.ui.presentation.widgets.bottomnavigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jcamarena.navigationincompose.ui.navigation.Routes

@Composable
fun BottomNavigation(
    navController: NavHostController,
    state: MutableState<Boolean>
) {

    AnimatedVisibility(
        visible = state.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        var selectedItem by rememberSaveable { mutableStateOf(0) }
        val items = listOf(
            Pair(Routes.Home, Icons.Default.Home),
            Pair(Routes.Profile, Icons.Default.Person),
            Pair(Routes.Settings, Icons.Default.Settings)
        )
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        selectedItem = items.indexOf(
            items.find { it.first.route == currentDestination?.route }
        )

        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        Icon(imageVector = items[index].second, contentDescription = null)
                    },
                    label = { Text(item.first.route) },
                    selected = selectedItem == index,
                    onClick = {
                        navController.navigate(items[index].first.route) {
                            popUpTo(Routes.Home.route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        selectedItem = index
                    }
                )
            }
        }
    }
}

@Composable
fun bottomBarVisibility(
    navController: NavHostController,
): MutableState<Boolean> {

    val bottomBarState = rememberSaveable { (mutableStateOf(false)) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    when (navBackStackEntry?.destination?.route) {
        Routes.Home.route -> bottomBarState.value = true
        Routes.Profile.route -> bottomBarState.value = true
        Routes.Settings.route -> bottomBarState.value = true
        else -> bottomBarState.value = false
    }

    return bottomBarState
}