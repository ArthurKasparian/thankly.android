/*
 Copyright (c) 2023 ~ 2023 Arthur Kasparian, Individual All Rights Reserved
 Unauthorized copying of this file, via any medium is strictly prohibited
 Proprietary and confidential
 Written by Arthur Kasparian <contact@arthurkasparian.dev>, Month 12 2023. Last modified 30/12/2023, 4:31 pm
 */

package dev.arthurkasparian.thankly.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

fun <VM: ViewModel> viewModelFactory(initializer: () -> VM): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return initializer() as T
        }
    }
}