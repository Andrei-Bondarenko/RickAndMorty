package com.example.rick_and_morty_main_page.di

import androidx.room.Room
import com.example.common.InjectionModule
import com.example.rick_and_morty_main_page.ui.RickAndMortyViewModel
import com.example.rick_and_morty_main_page.interactor.RickAndMortyInteractor
import com.example.rick_and_morty_main_page.api.RickAndMortyApi
import com.example.rick_and_morty_main_page.db.database.AppDatabase
import com.example.rick_and_morty_main_page.repository.local_repository.LocalRepository
import com.example.rick_and_morty_main_page.repository.local_repository.MainLocalRepository
import com.example.rick_and_morty_main_page.repository.remote.RickAndMortyRemoteRepository
import com.example.rick_and_morty_main_page.repository.remote.RickAndMortyRepository
import com.example.utils.Arguments
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

object RickAndMortyModule : InjectionModule {

    override fun create() = module {
        single {
            Room.databaseBuilder(get(), AppDatabase::class.java, "RickAndMortyDatabase")
                .build()
        }
        single { get<Retrofit>().create(RickAndMortyApi::class.java) }
        single { RickAndMortyRemoteRepository(get()) } bind RickAndMortyRepository::class
        single { MainLocalRepository(get()) } bind LocalRepository::class
        single { get<AppDatabase>().getCharacterDao() }
        factoryOf(::RickAndMortyInteractor)

        viewModelOf(::RickAndMortyViewModel)

    }
}