/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 10:17 pm
 */

package dev.arthurkasparian.thankly

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.datastore.dataStore
import dev.arthurkasparian.thankly.ui.screens.MainScreen
import dev.arthurkasparian.thankly.ui.theme.ThanklyTheme
import kotlinx.coroutines.launch

val Context.dataStore by dataStore("app-preferences.json", AppPreferencesSerializer)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            ThanklyTheme {

                val appPreferences = dataStore.data.collectAsState(initial = AppPreferences()).value
                val scope = rememberCoroutineScope()

                MainScreen(
                    onboardingDone = appPreferences.onboardingDone,
                    setOnboardingDone = { scope.launch { setOnboardingDone() } }
                )
            }
        }
    }


    // Datastore helper functions
    private suspend fun setOnboardingDone() {
        dataStore.updateData {
            it.copy(onboardingDone = true)
        }
    }
}