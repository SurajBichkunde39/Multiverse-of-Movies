package com.example.bookmyshowassignment.moviedetails.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookmyshowassignment.R
import com.example.bookmyshowassignment.moviedetails.model.MovieCredit

class CreditsAdapter(
    private val context: Context, private var credits: List<MovieCredit>
) : RecyclerView.Adapter<CreditsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_credit_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = credits.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = credits[position]
        holder.bind(person)
    }

    fun submitList(movieCredits: List<MovieCredit>) {
        Log.d("Something", "Submitting ${movieCredits.size} amount of data.")
        credits = movieCredits
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val creditImage: ImageView = itemView.findViewById(R.id.member_image)
        private val creditTitle: TextView = itemView.findViewById(R.id.member_name)
        private val creditSubtitle: TextView = itemView.findViewById(R.id.member_role)

        fun bind(movieCredit: MovieCredit) {
            Glide.with(itemView.context)
                .load(movieCredit.imageUrl)
                .circleCrop()
                .into(creditImage)
            creditTitle.text = movieCredit.personName
            creditSubtitle.text = movieCredit.roleInMovie
        }
    }
}