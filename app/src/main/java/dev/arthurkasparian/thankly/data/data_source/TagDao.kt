/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 10:17 pm
 */

package dev.arthurkasparian.thankly.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Upsert
import dev.arthurkasparian.thankly.domain.model.Tag

@Dao
interface TagDao {

    @Upsert
    suspend fun upsertTag(tag: Tag)

    @Insert
    suspend fun insertTags(tags: List<Tag>)

    @Delete
    suspend fun deleteTag(tag: Tag)
}