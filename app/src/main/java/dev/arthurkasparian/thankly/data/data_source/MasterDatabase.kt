/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 10:17 pm
 */

package dev.arthurkasparian.thankly.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.arthurkasparian.thankly.domain.model.Attachment
import dev.arthurkasparian.thankly.domain.model.Entry
import dev.arthurkasparian.thankly.domain.model.EntryChange
import dev.arthurkasparian.thankly.domain.model.Streak
import dev.arthurkasparian.thankly.domain.model.Tag
import dev.arthurkasparian.thankly.domain.util.LocalDateTimeConverter

@Database(
    entities = [
        Entry::class,
        EntryChange::class,
        Streak::class,
        Tag::class,
        Attachment::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(LocalDateTimeConverter::class)
abstract class MasterDatabase : RoomDatabase() {
    abstract val tagDao: TagDao

    abstract val entryDao: EntryDao

    companion object {
        const val DATABASE_NAME = "master_db"
    }
}