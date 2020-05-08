package com.example.android_technical_test.data

import com.google.gson.annotations.SerializedName

data class ArtistsSearchResponse(
    val topartists: ArtistsMetaData
)

data class ArtistsMetaData(
    val artist: List<ArtistResponse>
)

data class ArtistResponse(
    val name: String,
    val image: List<ImageResponse>
)

data class ImageResponse(
    @SerializedName("#text") val text: String,
    val size: String
)
