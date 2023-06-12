package com.example.rick_and_morty_main_page.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParametersList(
    val id: Int?,
    val name: String?,
    val status: String?,
    val species: String?,
    val type: String?,
    val image: String?,
    val gender: String?
) : Parcelable
