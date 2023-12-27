/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 27/12/2023, 10:38 pm
 */

package dev.arthurkasparian.thankly.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert
import dev.arthurkasparian.thankly.domain.model.Entry

@Dao
interface EntryDao {

    @Upsert
    suspend fun upsertEntry(entry: Entry)

    @Delete
    suspend fun deleteEntry(entry: Entry)

    // Queries
}