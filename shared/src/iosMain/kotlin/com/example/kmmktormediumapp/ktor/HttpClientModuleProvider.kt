package com.example.kmmktormediumapp.ktor

import io.ktor.client.*
import io.ktor.client.engine.darwin.*
import io.ktor.client.plugins.observer.*

actual class HttpClientModuleProvider {

    actual fun getPlatformSpecificClient() = HttpClient(Darwin) {
        installFeatures(this@HttpClient)
    }

    private fun installFeatures(config: HttpClientConfig<*>) = with(config) {
        install(ResponseObserver) {
            onResponse { response ->
                println("HTTP status IOS: ${response.status}")
            }
        }
    }
}