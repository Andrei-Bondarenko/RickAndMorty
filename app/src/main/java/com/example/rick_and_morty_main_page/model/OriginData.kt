package com.example.rick_and_morty_main_page.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OriginData(
    val name: String?,
    val url: String?
): Parcelable
