package com.example.rick_and_morty_main_page.di

import com.example.common.InjectionModule
import com.example.rick_and_morty_main_page.ui.RickAndMortyViewModel
import com.example.rick_and_morty_main_page.interactor.RickAndMortyInteractor
import com.example.rick_and_morty_main_page.api.RickAndMortyApi
import com.example.rick_and_morty_main_page.repository.RickAndMortyRemoteRepository
import com.example.rick_and_morty_main_page.repository.RickAndMortyRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

object RickAndMortyModule : InjectionModule {

    override fun create() = module {
        single { get<Retrofit>().create(RickAndMortyApi::class.java) }
        single { RickAndMortyRemoteRepository(get()) } bind RickAndMortyRepository::class
        factoryOf(::RickAndMortyInteractor)

        viewModelOf(::RickAndMortyViewModel)

    }
}