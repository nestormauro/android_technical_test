package com.example.android_technical_test.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_technical_test.domain.Artist
import com.example.android_technical_test.networking.WebClient
import kotlinx.coroutines.launch

class LastFmGeoViewModel : ViewModel() {
    private val mutablePhotosLiveData = MutableLiveData<List<Artist>>()
    val photosLiveData: LiveData<List<Artist>> = mutablePhotosLiveData

    init {
        viewModelScope.launch {
            val searchResponse = WebClient.client.fetchImages()
            val lastFmList = searchResponse.topartists.artist.map { lastFmData ->
                Artist(
                    name = lastFmData.name,
                    listeners = lastFmData.listeners,
                    mbid = lastFmData.mbid,
                    url = lastFmData.url,
                    text = lastFmData.image[0].text
                )
            }
            mutablePhotosLiveData.postValue(lastFmList)
        }
    }
}
