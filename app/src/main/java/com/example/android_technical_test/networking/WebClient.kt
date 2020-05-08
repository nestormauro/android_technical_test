package com.example.android_technical_test.networking

import com.google.gson.FieldNamingPolicy
import com.google.gson.FieldNamingStrategy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private const val BASE_URL = "https://ws.audioscrobbler.com/2.0/"
private const val CONNECTION_TIMEOUT_MS: Long = 10

var customPolicy =  FieldNamingStrategy { f -> f.name.replace("_", "") }

object WebClient {
    val client: ApiService by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .disableHtmlEscaping()
                        .setFieldNamingStrategy(customPolicy)
                        .create()
                )
            )
            .client(
                OkHttpClient.Builder().connectTimeout(
                    CONNECTION_TIMEOUT_MS,
                    TimeUnit.SECONDS
                ).addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BASIC
                }).build()
            )
            .build()
            .create(ApiService::class.java)
    }
}
