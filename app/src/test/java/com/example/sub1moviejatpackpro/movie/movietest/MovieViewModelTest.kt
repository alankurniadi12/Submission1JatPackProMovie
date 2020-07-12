package com.example.sub1moviejatpackpro.movie.movietest

import com.example.sub1moviejatpackpro.movie.MovieViewModel
import com.example.sub1moviejatpackpro.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel
    private val dataDummy = DataDummy.generateDummyMovie()[0]
    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getDetailMovies() {
        val dummyId = dataDummy.id
        viewModel.setSelectedDetail(dummyId)
        val dataDetailMovie = viewModel.getDetailMovies()
        assertNotNull(dataDetailMovie)              //apakah datadetail null?

        //apakah data yang tampil sesuai dengan Id hasil intent klik listitem?
        assertNotNull(dummyId, dataDetailMovie?.id)
        assertNotNull(dataDummy.poster.toString(), dataDetailMovie?.poster)
        assertNotNull(dataDummy.title, dataDetailMovie?.title)
        assertNotNull(dataDummy.score, dataDetailMovie?.score)
        assertNotNull(dataDummy.release, dataDetailMovie?.release)
        assertNotNull(dataDummy.duration, dataDetailMovie?.duration)
        assertNotNull(dataDummy.description, dataDetailMovie?.description)
    }

    @Test
    fun getMovies() {
        val dataMovie = viewModel.getMovies()
        assertNotNull(dataMovie)                            //apakah dataMovie yang didapatkan dari datadummy null?
        assertEquals(10, dataMovie.size)           //apakah list data berjumlah 10 item?
    }
}