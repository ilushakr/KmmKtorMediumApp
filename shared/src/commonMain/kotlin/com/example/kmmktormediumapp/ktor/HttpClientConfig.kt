package com.example.kmmktormediumapp.ktor

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

expect class HttpClientModuleProvider() {
    fun getPlatformSpecificClient(): HttpClient
}

class HttpClientModuleProviderBase {

    fun configureClient(): HttpClient {
        return HttpClientModuleProvider().getPlatformSpecificClient().apply {
            config {

                install(HttpRequestRetry) {
                    retryOnServerErrors(maxRetries = 5)
                }

                install(ContentNegotiation) {
                    json(Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    })
                }
            }
        }
    }
}

