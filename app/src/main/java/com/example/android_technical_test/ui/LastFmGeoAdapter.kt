package com.example.android_technical_test.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_technical_test.R
import com.example.android_technical_test.domain.Artist
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.artist_info.view.*

class LastFmGeoAdapter(val artists: MutableList<Artist> = mutableListOf()) : RecyclerView.Adapter<LastFmGeoAdapter.PhotosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.artist_info,
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
            itemView.textArtistName.text = artist.name
            itemView.textListeners.text = "Radio escuchas: " + artist.listeners
            itemView.textMbid.text = "mbid: " + artist.mbid
            itemView.textUrl.text = artist.url
            Picasso.get().load(artist.text).into(itemView.imageView)
        }
    }
}
