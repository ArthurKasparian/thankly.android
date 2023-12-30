/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 10:17 pm
 */

package dev.arthurkasparian.thankly

import android.app.Application
import dev.arthurkasparian.thankly.di.DatabaseModule
import dev.arthurkasparian.thankly.di.DatabaseModuleImpl
import dev.arthurkasparian.thankly.di.OnboardingModule
import dev.arthurkasparian.thankly.di.OnboardingModuleImpl

class ThanklyApp : Application() {

    companion object {
        lateinit var databaseModule: DatabaseModule
        lateinit var onboardingModule: OnboardingModule
    }

    override fun onCreate() {
        super.onCreate()

        databaseModule = DatabaseModuleImpl(this)
        onboardingModule = OnboardingModuleImpl(this)
    }
}