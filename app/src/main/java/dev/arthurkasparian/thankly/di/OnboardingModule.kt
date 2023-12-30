/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 10:17 pm
 */

package dev.arthurkasparian.thankly.di

import android.content.Context
import dev.arthurkasparian.thankly.ThanklyApp
import dev.arthurkasparian.thankly.data.repository.TagRepositoryImpl
import dev.arthurkasparian.thankly.domain.repository.TagRepository

// Todo implementation
interface OnboardingModule {
    val tagRepository: TagRepository
}

class OnboardingModuleImpl(
    private val context: Context // Not sure what this is for
): OnboardingModule {

    override val tagRepository: TagRepository
        by lazy {
            TagRepositoryImpl(ThanklyApp.databaseModule.masterDatabase.tagDao)
        }
}