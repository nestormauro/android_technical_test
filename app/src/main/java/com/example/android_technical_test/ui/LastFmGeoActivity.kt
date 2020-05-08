package com.example.android_technical_test.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_technical_test.R
import kotlinx.android.synthetic.main.activity_photos.*

class LastFmGeoActivity : AppCompatActivity() {
    private val lastFmGeoViewModel: LastFmGeoViewModel by viewModels()
    private val lastFmGeoAdapter = LastFmGeoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        lastFmGeoRecyclerView.adapter = lastFmGeoAdapter
        //lastFmGeoRecyclerView.layoutManager = GridLayoutManager(this, 3)
        lastFmGeoRecyclerView.layoutManager = LinearLayoutManager(this)
        lastFmGeoViewModel.photosLiveData.observe(this,
            Observer { list ->
                with(lastFmGeoAdapter) {
                    artists.clear()
                    artists.addAll(list)
                    notifyDataSetChanged()
                }
            })
    }
}
