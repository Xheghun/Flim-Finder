
package com.xheghun.kotlincoroutines.di

import com.xheghun.kotlincoroutines.contextProvider.CoroutineContextProvider
import com.xheghun.kotlincoroutines.contextProvider.CoroutineContextProviderImpl
import com.xheghun.kotlincoroutines.data.database.MovieDatabase
import com.xheghun.kotlincoroutines.domain.repository.MovieRepository
import com.xheghun.kotlincoroutines.domain.repository.MovieRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

fun appModule() = module {

    single { CoroutineContextProviderImpl(Dispatchers.IO) as CoroutineContextProvider }

    single { MovieDatabase.create(androidContext()) } // database

    single { get<MovieDatabase>().movieDao() } // dao

    single { MovieRepositoryImpl(get(), get(), get()) as MovieRepository } // repository
}