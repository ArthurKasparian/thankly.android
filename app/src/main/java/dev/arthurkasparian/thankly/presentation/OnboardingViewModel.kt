/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 10:17 pm
 */

package dev.arthurkasparian.thankly.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dev.arthurkasparian.thankly.domain.model.Tag
import dev.arthurkasparian.thankly.domain.repository.TagRepository
import kotlinx.coroutines.flow.StateFlow

class OnboardingViewModel(
    private val ssh: SavedStateHandle,
    private val repository: TagRepository
): ViewModel() {

    val tags: StateFlow<List<String>> =
        ssh.getStateFlow("tags", listOf())

    fun toggleTag(tag: String) {

        val list: MutableList<String> = tags.value.toMutableList()

        if (list.contains(tag))
            list.remove(tag)
        else
            list.add(tag)

        ssh["tags"] = list // .toImmutableList() not needed, Kotlin automatically performs it
    }

    /*val tags: StateFlow<Map<String, Boolean>> =
        ssh.getStateFlow(
            "tags",
            mapOf(
                "Family" to false,
                "Friends" to false,
                "Pets" to false,
                "Education" to false,
                "Hobbies" to false,
                "Music" to false,
            )
        )

    fun toggleTag(tag: String) {

        ssh["tags"] = tags.value.map {
            if (it.key == tag) it.key to !it.value
        }
    }*/

    // Todo(Add function to save tags to database)
    suspend fun saveTags() {

        val t: List<Tag> = tags.value.map { tag ->
            Tag(title = tag)
        }

        repository.insertTags(t)
    }
}