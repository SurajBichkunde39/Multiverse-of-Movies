package com.example.bookmyshowassignment.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.bookmyshowassignment.R
import com.google.android.material.appbar.MaterialToolbar

private const val MOVIE_ID = "param1"
private const val LOG_TAG = "MovieDetailFragment"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {
    private var movieId: String? = null
    private lateinit var toolbar: MaterialToolbar
    private lateinit var posterView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieId = it.getString(MOVIE_ID)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar)
        posterView = view.findViewById(R.id.poster)
        toolbar.title = "Avengers: Endgame"
        loadImage()
    }

    private fun loadImage(url: String? = null) {
        Log.d(LOG_TAG, "Loading started for poster image.")
        val posterUrl =
            url ?: "https://upload.wikimedia.org/wikipedia/en/0/0d/Avengers_Endgame_poster.jpg"
        Glide.with(this)
            .load(posterUrl)
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
        fun newInstance(movieId: String) =
            MovieDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(MOVIE_ID, movieId)
                }
            }
    }
}
