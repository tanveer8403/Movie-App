package com.example.movieapp1216609

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private var movies: ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.titleText.text = movie.title
        holder.genreText.text = movie.genre
    }

    override fun getItemCount(): Int = movies.size

    fun updateMovies(newMovies: ArrayList<Movie>) {
        this.movies = newMovies
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.movieTitleText)
        val genreText: TextView = itemView.findViewById(R.id.movieGenreText)
    }
}
