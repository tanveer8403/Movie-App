package com.example.movieapp1216609

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        movieAdapter = MovieAdapter(ArrayList())

        val recyclerView = findViewById<RecyclerView>(R.id.movieRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = movieAdapter

        val movieTitle = findViewById<EditText>(R.id.movieTitle)
        val movieGenre = findViewById<EditText>(R.id.movieGenre)
        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            val title = movieTitle.text.toString()
            val genre = movieGenre.text.toString()
            if (title.isNotEmpty() && genre.isNotEmpty()) {
                movieViewModel.addMovie(title, genre)
            }
        }

        movieViewModel.movieAdded.observe(this) {
            movieAdapter.updateMovies(movieViewModel.movies.value ?: ArrayList())
        }
    }
}
