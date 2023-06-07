package com.example.kmmktormediumapp.di

import com.example.kmmktormediumapp.ktor.HttpClientModuleProviderBase
import org.koin.dsl.module

val networkBaseModule = module {

    single {
        HttpClientModuleProviderBase().configureClient()
    }

}