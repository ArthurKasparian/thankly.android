/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 10:17 pm
 */

package dev.arthurkasparian.thankly.ui.screens.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.arthurkasparian.thankly.ui.screens.onboarding.components.OnboardingButtonRow
import dev.arthurkasparian.thankly.ui.screens.onboarding.components.TagPicker
import dev.arthurkasparian.thankly.ui.theme.ThanklyTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagsScreen(
    modifier: Modifier = Modifier,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    onToggleTag: (String) -> Unit,
    tags: List<String>
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {

            // Todo(Replace with string resource)
            Text(
                text = "What are you usually thankful for?".uppercase(),
                style = MaterialTheme.typography.displayMedium
            )

            FlowRow(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                listOf(
                    "Family",
                    "Friends",
                    "Pets",
                    "Education",
                    "Hobbies",
                    "Music",
                ).forEach {

                    TagPicker(
                        tag = it,
                        toggled = tags.contains(it), // Since we're already keeping track of the tags, we can just use the ViewModel state as opposed to a new rememberSaveable {}
                        onToggle = { onToggleTag(it) }
                    )
                }

            }
        }

        OnboardingButtonRow(
            onNextClick = onNextClick, // Todo(Add tags to database first)
            onBackCLick = onBackClick,
            done = true
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TagsScreenPreview() {
    ThanklyTheme {
        TagsScreen(onNextClick = {}, onBackClick = {}, onToggleTag = {}, tags = listOf("Test Tag"))
    }
}