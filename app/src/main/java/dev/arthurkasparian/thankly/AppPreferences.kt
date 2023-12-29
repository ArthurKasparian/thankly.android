/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 29/12/2023, 3:35 am
 */

package dev.arthurkasparian.thankly

import kotlinx.serialization.Serializable

@Serializable
data class AppPreferences(
    val onboardingDone: Boolean = false,
)