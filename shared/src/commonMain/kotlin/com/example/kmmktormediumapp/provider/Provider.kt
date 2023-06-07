package com.example.kmmktormediumapp.provider

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Provider: KoinComponent {
    private val client by inject<HttpClient>()

    suspend fun getUser(): String {
        return client.request("https://jsonplaceholder.typicode.com/users/1").body<String>()
    }
}