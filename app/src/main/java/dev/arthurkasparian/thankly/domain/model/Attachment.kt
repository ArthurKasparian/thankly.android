/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 28/12/2023, 12:11 am
 */

package dev.arthurkasparian.thankly.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Attachment(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    // Maybe add type of attachment, i.e.: Audio, Video, File etc...
    val reference: String,

    @ColumnInfo(name = "entry_id") val entryId: Int
)