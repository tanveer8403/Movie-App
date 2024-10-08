package com.example.movieapp1216609

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieViewModel : ViewModel() {
    private val _movies = MutableLiveData<ArrayList<Movie>>().apply { value = ArrayList() }
    val movies: LiveData<ArrayList<Movie>> = _movies
    val movieAdded = MutableLiveData<Boolean>()

    fun addMovie(title: String, genre: String) {
        _movies.value?.add(Movie(title, genre))
        _movies.value = _movies.value // to trigger observer
        movieAdded.value = true
    }
}
