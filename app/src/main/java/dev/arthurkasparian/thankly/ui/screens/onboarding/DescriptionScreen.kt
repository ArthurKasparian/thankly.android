/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 10:17 pm
 */

package dev.arthurkasparian.thankly.ui.screens.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.arthurkasparian.thankly.R
import dev.arthurkasparian.thankly.ui.screens.onboarding.components.OnboardingButtonRow
import dev.arthurkasparian.thankly.ui.theme.ThanklyTheme

@Composable
fun DescriptionScreen(
    modifier: Modifier = Modifier,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = MaterialTheme.typography.displayLarge
                        .copy(color = MaterialTheme.colorScheme.onBackground)
                        .toSpanStyle()
                ) {
                    append(text = stringResource(id = R.string.app_name).uppercase() + "\n")
                }

                withStyle(
                    style = MaterialTheme.typography.bodyMedium
                        .copy(color = MaterialTheme.colorScheme.onBackground)
                        .toSpanStyle()
                ) {
                    // Todo(Add actual content :p)
                    // Todo(Replace with string resource)
                    append(text = "\nyour warm and fuzzy gratitude haven. This app is like a comfy blanket for your thoughts – just snuggle in and jot down what made your day special. No frills, just a cozy space to embrace the good vibes. Try Thankly, where gratitude feels like a warm hug for your soul.")
                }
            }
        )

        OnboardingButtonRow(
            modifier = Modifier.fillMaxWidth(),
            onNextClick = onNextClick,
            onBackCLick = onBackClick,
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DescriptionScreenPreview() {
    ThanklyTheme {

        DescriptionScreen(onNextClick = {}, onBackClick = {})
    }
}