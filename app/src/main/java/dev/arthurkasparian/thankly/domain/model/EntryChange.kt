/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 28/12/2023, 12:30 am
 */

package dev.arthurkasparian.thankly.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class EntryChange(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "entry_id") val entryId: Int,

    val title: String?,
    val description: String?,
    val date: LocalDate?, // Date set by user
    val emotion: String?, // Use emotion enum
    val favourite: Boolean?,

    @ColumnInfo(name="change_time") val changeTime: LocalDateTime = LocalDateTime.now()
)