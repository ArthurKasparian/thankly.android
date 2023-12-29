/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 29/12/2023, 9:54 pm
 */

package dev.arthurkasparian.thankly.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import dev.arthurkasparian.thankly.presentation.screens.onboarding.DescriptionScreen
import dev.arthurkasparian.thankly.presentation.screens.onboarding.TagsScreen
import dev.arthurkasparian.thankly.presentation.screens.onboarding.WelcomeScreen

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    onboardingDone: Boolean,
    setOnboardingDone: () -> Unit,
    navController: NavHostController
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = if (onboardingDone) NavigationGraphs.Journal.name else NavigationGraphs.Onboarding.name
    ) {

        // Onboarding screens
        navigation(
            startDestination = OnboardingScreens.Welcome.name,
            route = NavigationGraphs.Onboarding.name
        ) {

            composable(OnboardingScreens.Welcome.name) {
                WelcomeScreen(
                    onClick = { navController.navigate(OnboardingScreens.Description.name) }
                )
            }

            composable(OnboardingScreens.Description.name) {
                DescriptionScreen(
                    onBackClick = { navController.popBackStack() },
                    onNextClick = { navController.navigate(OnboardingScreens.Tags.name) }
                )
            }

            composable(OnboardingScreens.Tags.name) {
                TagsScreen(
                    onBackClick = { navController.popBackStack() },
                    onNextClick = {
                        // setOnboardingDone() Todo(enable this once done with onboarding)
                        // navController.popBackStack(NavigationGraphs.Journal.name, true)

                        // navController.clearBackStack(NavigationGraphs.Journal.name)

                        // navController.navigate(NavigationGraphs.Journal.name)
                    }
                )
            }

        }

        navigation(
            startDestination = JournalScreens.Home.name,
            route = NavigationGraphs.Journal.name
        ) {

            composable(JournalScreens.Home.name) {
                Text(text = "Home Screen")
            }

            composable(JournalScreens.Entry.name) {

            }

            composable(JournalScreens.Calendar.name) {

            }

            composable(JournalScreens.Favourites.name) {

            }

            composable(JournalScreens.Preferences.name) {

            }

        }
    }
}