package com.example.android_technical_test.networking

import com.example.android_technical_test.data.ArtistsSearchResponse
import retrofit2.http.GET

interface ApiService {
    @GET("?method=geo.gettopartists&country=spain&api_key=829751643419a7128b7ada50de590067&format=json")
    suspend fun fetchImages(): ArtistsSearchResponse
}
