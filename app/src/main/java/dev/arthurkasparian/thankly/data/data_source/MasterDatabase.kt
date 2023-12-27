/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 27/12/2023, 10:52 pm
 */

package dev.arthurkasparian.thankly.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.arthurkasparian.thankly.domain.model.Entry

@Database(
    entities = [
        Entry::class
    ],
    version = 1,
    exportSchema = false
)
//@TypeConverter()
abstract class MasterDatabase : RoomDatabase() {
    abstract val entryDao: EntryDao

    companion object {
        const val DATABASE_NAME = "master_db"
    }
}