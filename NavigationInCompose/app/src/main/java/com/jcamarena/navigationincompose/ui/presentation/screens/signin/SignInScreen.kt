package com.jcamarena.navigationincompose.ui.presentation.screens.signin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SignInScreen(
    onLoginPressed: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
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