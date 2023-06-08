package com.example.rick_and_morty_main_page.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultsList(
    val id: Int?,
    val name: String?,
    val status: String?,
    val species: String?,
    val type: String?,
    val gender: String?,
    val origin: OriginData?,
    val location: LocationData?,
    val image: String?,
    val episode: List<String>?,
) : Parcelable
