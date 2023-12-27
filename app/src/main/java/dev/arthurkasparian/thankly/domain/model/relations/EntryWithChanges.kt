/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 28/12/2023, 12:30 am
 */

package dev.arthurkasparian.thankly.domain.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import dev.arthurkasparian.thankly.domain.model.Entry
import dev.arthurkasparian.thankly.domain.model.EntryChange

data class EntryWithChanges(
    @Embedded val entry: Entry,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        entity = EntryChange::class
    ) val changes: List<EntryChange>
)