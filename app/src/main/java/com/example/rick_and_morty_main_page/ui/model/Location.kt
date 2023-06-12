package com.example.rick_and_morty_main_page.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    val name: String?
): Parcelable
