package com.example.bookmyshowassignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bookmyshowassignment.ui.MovieDetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.fragment_container,
                    MovieDetailFragment.newInstance(movieId = 453395)
                )
                .commit()
        }
    }
}
