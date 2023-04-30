package com.example.bookmyshowassignment.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.bookmyshowassignment.R
import com.example.bookmyshowassignment.data.model.Movie
import com.google.android.material.appbar.MaterialToolbar
import dagger.hilt.android.AndroidEntryPoint

private const val MOVIE_ID = "movie_id_param"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {
    private var movieId = 453395
    private lateinit var toolbar: MaterialToolbar
    private lateinit var posterView: ImageView

    private val movieDetailsViewModel by viewModels<MovieDetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieId = it.getInt(MOVIE_ID)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar)
        posterView = view.findViewById(R.id.poster)
        movieDetailsViewModel.movieDetails.observe(viewLifecycleOwner, ::onMovieDataLoaded)
        movieDetailsViewModel.loadMovieDetails(movieId)
    }

    private fun onMovieDataLoaded(movie: Movie) {
        toolbar.title = movie.title
        loadImage(movie.posterPath)
    }

    private fun loadImage(url: String) {
        val baseUrl = "https://image.tmdb.org/t/p/w300"
        Glide.with(this)
            .load(baseUrl + url)
            .into(posterView)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param movieId for details.
         * @return A new instance of fragment MovieDetailFragment.
         */
        @JvmStatic
        fun newInstance(movieId: Int) =
            MovieDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(MOVIE_ID, movieId)
                }
            }
    }
}
