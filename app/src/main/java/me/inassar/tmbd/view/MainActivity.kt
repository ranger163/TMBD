package me.inassar.tmbd.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.inassar.tmbd.R
import me.inassar.tmbd.view.moviedetails.MovieDetailsActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        open.setOnClickListener {
            startActivity(
                Intent(this@MainActivity, MovieDetailsActivity::class.java)
                    .putExtra("id", 475557)
            )
        }
    }
}
