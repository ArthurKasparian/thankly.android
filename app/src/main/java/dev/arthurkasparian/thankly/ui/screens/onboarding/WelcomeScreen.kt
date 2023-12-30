/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 10:17 pm
 */

package dev.arthurkasparian.thankly.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import dev.arthurkasparian.thankly.R
import dev.arthurkasparian.thankly.ui.screens.onboarding.components.OnboardingButton
import dev.arthurkasparian.thankly.ui.theme.ThanklyTheme

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        // Todo(Add Logo)
        Image(
            painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Thankly Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(.5f)
        )

        // Todo(Replace with string resource)
        Text(
            modifier = Modifier,
            text = buildAnnotatedString {
                append(text = "Welcome to".uppercase())
                appendLine()
                append(text = stringResource(id = R.string.app_name).uppercase())
            },
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        OnboardingButton(onClick = onClick)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun WelcomeScreenPreview() {
    ThanklyTheme {
        WelcomeScreen(onClick = {})
    }
}