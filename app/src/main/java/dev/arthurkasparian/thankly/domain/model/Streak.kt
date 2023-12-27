/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 27/12/2023, 11:56 pm
 */

package dev.arthurkasparian.thankly.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class Streak(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val start: LocalDate,
    val end: LocalDate? = null,
    val length: Int = 0
)