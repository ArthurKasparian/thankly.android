/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 10:17 pm
 */

package dev.arthurkasparian.thankly.domain.repository

import dev.arthurkasparian.thankly.domain.model.Tag

interface TagRepository {

    // Insert + update combination
    suspend fun upsertTag(tag: Tag)

    suspend fun insertTags(tags: List<Tag>)

    // Permanently deletes tag from database
    suspend fun deleteTag(tag: Tag)
}