package com.jcamarena.navigationincompose.ui.navigation

import androidx.navigation.NavController

fun NavController.navigateToGreetingScreen(name: String) {
    this.navigate("${Routes.HomeGreeting.route}/$name")
}