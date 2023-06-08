package com.example.rick_and_morty_main_page.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RickAndMortyInfoData(
    val info: RickAndMortyInfo?,
    val results: List<ResultsList?>?
) : Parcelable
