/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 29/12/2023, 3:56 am
 */

package dev.arthurkasparian.thankly.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

// Todo(Implement onboarding logic on startDestination)
@Composable
fun NavigationHost(
    onboardingDone: Boolean
) {

    NavHost(
        navController = rememberNavController(),
        startDestination = if (onboardingDone) NavigationGraphs.Journal.name else NavigationGraphs.Onboarding.name // Todo(Onboarding logic)
    ) {
        // Onboarding screens
        navigation(
            startDestination = OnboardingScreens.Welcome.name,
            route = NavigationGraphs.Onboarding.name
        ) {

            composable(OnboardingScreens.Welcome.name) {

            }

            composable(OnboardingScreens.Description.name) {

            }

            composable(OnboardingScreens.Tags.name) {

            }

        }

        navigation(
            startDestination = JournalScreens.Feed.name,
            route = NavigationGraphs.Journal.name
        ) {

            composable(JournalScreens.Feed.name) {

            }

            composable(JournalScreens.Entry.name) {

            }

            composable(JournalScreens.Calendar.name) {

            }

            composable(JournalScreens.Favourites.name) {

            }

            composable(JournalScreens.Settings.name) {

            }

        }
    }
}