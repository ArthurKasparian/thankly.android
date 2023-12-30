/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 10:17 pm
 */

package dev.arthurkasparian.thankly.data.repository

import dev.arthurkasparian.thankly.data.data_source.TagDao
import dev.arthurkasparian.thankly.domain.model.Tag
import dev.arthurkasparian.thankly.domain.repository.TagRepository

class TagRepositoryImpl(
    private val dao: TagDao
) : TagRepository {

    override suspend fun upsertTag(tag: Tag) {
        dao.upsertTag(tag)
    }

    override suspend fun insertTags(tags: List<Tag>) {
        dao.insertTags(tags)
    }

    override suspend fun deleteTag(tag: Tag) {
        dao.deleteTag(tag)
    }
}