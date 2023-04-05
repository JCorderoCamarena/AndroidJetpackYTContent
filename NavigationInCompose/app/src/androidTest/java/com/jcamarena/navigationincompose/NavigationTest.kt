package com.jcamarena.navigationincompose

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.jcamarena.navigationincompose.ui.presentation.scaffold.MainScaffold
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            MainScaffold(
                navController = navController
            )
        }
    }

    @Test
    fun verifyStartDestinationIsSplashScreen() {
        composeTestRule
            .onNodeWithText("Loading...")
            .assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun verifySecondDestinationIsLoginScreen() {
        composeTestRule.apply {
            waitUntilExactlyOneExists(hasText("Go to Sign Up"), 1200)

            assert("signIn" == getCurrentRoute())

            onNodeWithText("Go to Sign Up")
                .assertExists("No node found")

            onNodeWithText("Go to Sign Up")
                .performClick()


            onNodeWithText("Create user!")
                .assertExists("Node not found")

            assert("signUp" == getCurrentRoute()) { "Expected: signUp, Found: ${getCurrentRoute()}" }

            onNodeWithText("Create user!")
                .performClick()

            onNodeWithText("Go to Sign Up")
                .assertExists("No node found")

            assert("signIn" == getCurrentRoute())
        }
    }

    private fun getCurrentRoute(): String? {
        return navController.currentBackStackEntry?.destination?.route
    }
}