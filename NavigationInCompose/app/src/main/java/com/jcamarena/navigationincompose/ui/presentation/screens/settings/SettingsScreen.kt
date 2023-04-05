package com.jcamarena.navigationincompose.ui.presentation.screens.settings

import androidx.compose.runtime.Composable
import com.jcamarena.navigationincompose.ui.presentation.widgets.AuthenticatedScreen

@Composable
fun SettingsScreen(
    onLogoutPressed: () -> Unit
) {
    AuthenticatedScreen(
        label = "Settings",
        onLogoutPressed = onLogoutPressed
    )
}