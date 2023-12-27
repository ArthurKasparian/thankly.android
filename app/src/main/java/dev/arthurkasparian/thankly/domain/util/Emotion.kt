/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 28/12/2023, 12:26 am
 */

package dev.arthurkasparian.thankly.domain.util

// To be used in viewModels when creating/reading entries instead of bothering with TypeConverters
enum class Emotion(
    val reference: String
) {
    Happy(reference = ""),
    Sad(reference = "")

    // Todo(Add emotions and emoticons)
}