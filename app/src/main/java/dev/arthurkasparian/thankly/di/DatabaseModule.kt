/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 10:17 pm
 */

package dev.arthurkasparian.thankly.di

import android.app.Application
import androidx.room.Room
import dev.arthurkasparian.thankly.data.data_source.MasterDatabase

interface DatabaseModule {
    val masterDatabase: MasterDatabase
}

class DatabaseModuleImpl(
    private val app: Application
): DatabaseModule {

    override val masterDatabase: MasterDatabase
        by lazy {
            Room.databaseBuilder(
                app,
                MasterDatabase::class.java,
                MasterDatabase.DATABASE_NAME
            ).build()
        }
}