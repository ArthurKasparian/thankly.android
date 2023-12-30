/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 10:17 pm
 */

package dev.arthurkasparian.thankly.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import dev.arthurkasparian.thankly.ThanklyApp
import dev.arthurkasparian.thankly.presentation.OnboardingViewModel
import dev.arthurkasparian.thankly.presentation.viewModelFactory
import dev.arthurkasparian.thankly.ui.screens.onboarding.DescriptionScreen
import dev.arthurkasparian.thankly.ui.screens.onboarding.TagsScreen
import dev.arthurkasparian.thankly.ui.screens.onboarding.WelcomeScreen
import kotlinx.coroutines.launch

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

                val viewModel = viewModel<OnboardingViewModel>(
                    factory = viewModelFactory {
                        OnboardingViewModel(
                            ssh = SavedStateHandle(),
                            repository = ThanklyApp.onboardingModule.tagRepository
                        )
                    }
                )

                val scope = rememberCoroutineScope()

                TagsScreen(
                    onBackClick = { navController.popBackStack() },
                    onNextClick = {
                        // setOnboardingDone() Todo(enable this once done with onboarding)
                        // navController.popBackStack(NavigationGraphs.Journal.name, true)

                        // navController.clearBackStack(NavigationGraphs.Journal.name)

                        // navController.navigate(NavigationGraphs.Journal.name)
                        scope.launch {
                            viewModel.saveTags()
                        }
                    },
                    onToggleTag = { viewModel.toggleTag(it) },
                    tags = viewModel.tags.collectAsState().value
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