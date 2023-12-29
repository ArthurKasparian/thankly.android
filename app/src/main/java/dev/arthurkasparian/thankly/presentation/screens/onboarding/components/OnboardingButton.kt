/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 29/12/2023, 10:37 pm
 */

package dev.arthurkasparian.thankly.presentation.screens.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingButton(
    modifier: Modifier = Modifier,
    direction: Boolean = true, // true -> right, false -> left
    onClick: () -> Unit,
    icon: ImageVector? = null
) {

    Box(
        modifier = modifier
            .dropShadow()
            .background(color = MaterialTheme.colorScheme.primary)
            .border(
                width = 2.dp,
                color = Color.Black
            )
            .size(56.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {

        Icon(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            imageVector = when {
                icon != null -> icon
                direction -> Icons.Default.ArrowForward
                else -> Icons.Default.ArrowBack
            },
            contentDescription = "Navigation Button",
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }

}

@Preview(showBackground = true)
@Composable
fun OnboardingButtonPreview() {


    Row(
        modifier = Modifier.padding(2.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        OnboardingButton(direction = true, onClick = {})
        OnboardingButton(direction = false, onClick = {})
    }
}

fun Modifier.dropShadow(color: Color = Color.Black, offset: Float = 6f): Modifier {
    return this.drawBehind {
        drawRect(color = color, size = size, topLeft = Offset(offset, offset))
    }
}