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
            val photosList = searchResponse.topartists.artist.map { photo ->
                Artist(
                    name = photo.name,
                    text = photo.image[3].text
                )
            }
            mutablePhotosLiveData.postValue(photosList)
        }
    }
}
