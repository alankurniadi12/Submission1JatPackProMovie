package com.example.sub1moviejatpackpro.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sub1moviejatpackpro.R
import com.example.sub1moviejatpackpro.model.Movie
import kotlinx.android.synthetic.main.fragment_list_movie.*


class ListMovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
            val movies = viewModel.getMovies()
            val movieAdapter = MovieAdapter()
            showShimmer(false)
            rv_movies.visibility = View.VISIBLE
            movieAdapter.setMovies(movies)
            showRecyclerView(movieAdapter)
        }
    }

    private fun showRecyclerView(movieAdapter: MovieAdapter) {
        with(rv_movies){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }

        movieAdapter.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Movie) {
               val intent = Intent(context, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, data.id)
                startActivity(intent)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        shimmer_list_movie.startShimmer()
    }

    override fun onPause() {
        shimmer_list_movie.stopShimmer()
        super.onPause()
    }

    private fun showShimmer(state: Boolean) {
        if (state) {
            shimmer_list_movie.startShimmer()
        }else {
            shimmer_list_movie.stopShimmer()
            shimmer_list_movie.visibility = View.GONE
        }
    }
}