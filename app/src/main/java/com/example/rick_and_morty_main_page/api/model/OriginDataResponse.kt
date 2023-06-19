package com.example.rick_and_morty_main_page.api.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OriginDataResponse(
    val name: String?,
    val url: String?
) : Parcelable
