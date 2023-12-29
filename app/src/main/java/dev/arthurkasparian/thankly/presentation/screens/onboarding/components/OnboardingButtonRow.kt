/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 29/12/2023, 8:58 pm
 */

package dev.arthurkasparian.thankly.presentation.screens.onboarding.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingButtonRow(
    modifier: Modifier = Modifier,
    onBackCLick: () -> Unit,
    onNextClick: () -> Unit,
    done: Boolean = false, // When the sequence is finished, this will be called true and the last 'next' button will be replaced with a 'done' button
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        OnboardingButton(
            onClick = onBackCLick,
            direction = false
        )

        OnboardingButton(
            onClick = onNextClick,
            icon = if (done) Icons.Filled.Done else null,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OnboardingButtonRowPreview() {
    OnboardingButtonRow(onBackCLick = {}, onNextClick = {})
}