package com.jcamarena.navigationincompose.ui.presentation.screens.profile

import androidx.compose.runtime.Composable
import com.jcamarena.navigationincompose.ui.presentation.widgets.AuthenticatedScreen

@Composable
fun ProfileScreen(
    onLogoutPressed: () -> Unit
) {
    AuthenticatedScreen(
        label = "Profile",
        onLogoutPressed = onLogoutPressed
    )
}