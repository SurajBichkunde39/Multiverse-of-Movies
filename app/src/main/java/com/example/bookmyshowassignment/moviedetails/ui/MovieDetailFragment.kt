package com.example.bookmyshowassignment.moviedetails.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookmyshowassignment.R
import com.example.bookmyshowassignment.booking.ui.TicketBookingActivity
import com.example.bookmyshowassignment.moviedetails.model.Movie
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
    private lateinit var infoContainer: View
    private lateinit var castRecyclerView: RecyclerView
    private lateinit var crewRecyclerView: RecyclerView
    private lateinit var bookTicketsButton: Button

    private lateinit var castAdapter: CreditsAdapter
    private lateinit var crewAdapter: CreditsAdapter

    private val movieDetailsViewModel by viewModels<MovieDetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieId = it.getInt(MOVIE_ID)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        setUpRecyclerViews()
        with(movieDetailsViewModel) {
            movieDetails.observe(viewLifecycleOwner, ::onMovieDataLoaded)
            cast.observe(viewLifecycleOwner) { castAdapter.submitList(it) }
            crew.observe(viewLifecycleOwner) { crewAdapter.submitList(it) }
            loadMovieDetails(movieId)
        }
    }

    private fun initializeViews(view: View) {
        toolbar = view.findViewById(R.id.toolbar)
        posterView = view.findViewById(R.id.poster)
        infoContainer = view.findViewById(R.id.info_container)
        castRecyclerView = view.findViewById(R.id.cast_recycler_view)
        crewRecyclerView = view.findViewById(R.id.crew_recycler_view)
        bookTicketsButton = view.findViewById<Button?>(R.id.book_tickets_btn).apply {
            setOnClickListener {
                val intent = Intent(requireContext(), TicketBookingActivity::class.java)
                intent.putExtra("movie_id", movieId)
                startActivity(intent)
            }
        }
    }

    private fun setUpRecyclerViews() {
        castAdapter = CreditsAdapter(requireContext(), emptyList())
        castRecyclerView.adapter = castAdapter
        castRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        crewAdapter = CreditsAdapter(requireContext(), emptyList())
        crewRecyclerView.adapter = crewAdapter
        crewRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun onMovieDataLoaded(movie: Movie) {
        toolbar.title = movie.title
        loadImage(movie.posterPath)
        showMovieInfo(movie)
    }

    private fun showMovieInfo(movie: Movie) {
        with(infoContainer) {
            findViewById<TextView>(R.id.response_info_rating).apply {
                text = context.getString(
                    R.string.rating_string, String.format("%.1f", movie.voteAverage)
                )
            }
            findViewById<TextView>(R.id.response_info_votes).apply {
                text = context.getString(
                    R.string.votes_string, movie.voteCount.toString()
                )
            }
            visibility = View.VISIBLE
        }
    }

    private fun loadImage(url: String?) {
        if (url != null) {
            Glide.with(this).load(url.toRequestsUrl()).into(posterView)
        } else {
            // TODO("Fallback to the default url.")
        }
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
        fun newInstance(movieId: Int) = MovieDetailFragment().apply {
            arguments = Bundle().apply {
                putInt(MOVIE_ID, movieId)
            }
        }
    }
}
