package com.example.bookmyshowassignment.booking.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bookmyshowassignment.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TicketBookingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_booking)

        val movieId = intent.getIntExtra("movie_id", 0)
        findViewById<TextView>(R.id.textView).apply {
            text = context.getString(R.string.booking_string, movieId)
        }
    }
}