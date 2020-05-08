package com.example.android_technical_test.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_technical_test.R
import com.example.android_technical_test.domain.Artist
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.photo.view.imageView

class LastFmGeoAdapter(val artists: MutableList<Artist> = mutableListOf()) : RecyclerView.Adapter<LastFmGeoAdapter.PhotosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.photo,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = artists.size

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(artists[position])
    }

    inner class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(artist: Artist) {
            Picasso.get().load(artist.text).into(itemView.imageView)
        }
    }
}
