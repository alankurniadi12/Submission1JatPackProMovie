package com.example.sub1moviejatpackpro.movie

import androidx.lifecycle.ViewModel
import com.example.sub1moviejatpackpro.model.Movie
import com.example.sub1moviejatpackpro.utils.DataDummy

class MovieViewModel: ViewModel() {
    private lateinit var id: String

    fun setSelectedDetail(id: String){
        this.id = id
    }

    fun getDetailMovies(): Movie? {
        var data: Movie? = null
        for (movies in DataDummy.generateDummyMovie()) {
            if (movies.id == id) {
                data = movies
            }
        }
        return data
    }

    fun getMovies(): ArrayList<Movie> = DataDummy.generateDummyMovie()
}