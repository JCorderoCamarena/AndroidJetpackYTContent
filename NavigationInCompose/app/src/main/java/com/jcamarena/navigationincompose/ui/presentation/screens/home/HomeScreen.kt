package com.jcamarena.navigationincompose.ui.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onLogoutPressed: () -> Unit,
    onNavigateToGreeting: (String) -> Unit
) {
    var name by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(vertical = 10.dp),
        ) {
            Text(text = "Home")

        }

        Column {
            TextField(
                value = name,
                onValueChange = {
                    name = it
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    onNavigateToGreeting(name)
                },
                enabled = !name.isNullOrEmpty()
            ) {
                Text(text = "Say Hi!")
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(vertical = 10.dp),
        ) {
            Button(onClick = onLogoutPressed) {
                Text(text = "Log me out!")
            }
        }
    }
}