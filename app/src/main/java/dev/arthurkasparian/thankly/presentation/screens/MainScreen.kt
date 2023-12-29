/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 29/12/2023, 6:18 pm
 */

package dev.arthurkasparian.thankly.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.arthurkasparian.thankly.presentation.navigation.NavigationHost
import dev.arthurkasparian.thankly.presentation.screens.components.BottomBar

@Composable
fun MainScreen(
    onboardingDone: Boolean,
    setOnboardingDone: () -> Unit
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            if (onboardingDone)
                BottomBar(
                    currentRoute = navBackStackEntry?.destination?.route,
                    navigateToRoute = {
                        navController.navigate(it)
                    }
                )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) {

        NavigationHost(
            modifier = Modifier.padding(it),
            navController = navController,
            onboardingDone = onboardingDone,
            setOnboardingDone = setOnboardingDone
        )
    }
}