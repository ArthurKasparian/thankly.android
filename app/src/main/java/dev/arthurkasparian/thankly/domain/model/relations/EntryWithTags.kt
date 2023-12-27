/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 27/12/2023, 10:49 pm
 */

package dev.arthurkasparian.thankly.domain.model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import dev.arthurkasparian.thankly.domain.model.Entry
import dev.arthurkasparian.thankly.domain.model.Tag

data class EntryWithTags(
    @Embedded val entry: Entry,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        entity = Tag::class,
        associateBy = Junction(TaggedEntry::class)
    ) val tags: List<Tag>
)