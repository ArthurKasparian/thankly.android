/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 27/12/2023, 10:39 pm
 */

package dev.arthurkasparian.thankly.domain.model.relations

import androidx.room.Entity

@Entity(
    tableName = "tagged_entry",
    primaryKeys = ["entryId", "tagId"]
)
data class TaggedEntry(
    val entityId: Long,
    val tagId: Long
)