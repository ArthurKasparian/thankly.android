/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 10:17 pm
 */

package dev.arthurkasparian.thankly.ui.screens.onboarding.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TagPicker(
    modifier: Modifier = Modifier,
    tag: String,
    toggled: Boolean,
    onToggle: () -> Unit
) {

    val backgroundColor: Color by animateColorAsState(
        if (toggled)
            MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.background,
        label = "Toggle colour change"
    )
    
    val offset: Dp by animateDpAsState(
        if (toggled)
            0.dp
        else (-2).dp,
        label = "Toggle Offset"
    )

    Box(
        modifier = modifier
            .dropShadow(offset = 0f)
            .offset(x = offset, y = offset)
            .border(
                2.dp,
                Color.Black
            )
            .background(backgroundColor)
            .clickable { onToggle() }
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = tag,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodyMedium
        )
    }

}

@Preview
@Composable
private fun TagPickerPreview() {
    MaterialTheme {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            TagPicker(tag = "Family", toggled = false) {}
            TagPicker(tag = "Family", toggled = true) {}
        }
    }
}