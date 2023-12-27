/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 28/12/2023, 12:14 am
 */

package dev.arthurkasparian.thankly.domain.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import dev.arthurkasparian.thankly.domain.model.Attachment
import dev.arthurkasparian.thankly.domain.model.Entry

data class EntryWithAttachments(
    @Embedded val entry: Entry,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        entity = Attachment::class,
    ) val attachments: List<Attachment>
)