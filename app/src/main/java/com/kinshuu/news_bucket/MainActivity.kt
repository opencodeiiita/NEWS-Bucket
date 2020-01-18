package com.kinshuu.news_bucket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val news = listOf("OpenCode'20 began on 17.Jan.2020",
                "This is dummy news.Pay no attention to it.",
                "Cows lose their jobs as milk prices drop.",
                "Miracle cure kills fifth patient",
                "Most Earthquake Damage is Caused by Shaking",
                "Bugs flying around with wings are flying bugs",
                "Farmer using cannon to protect watermelons",
                "Diana was still alive hours before she died")
        listView.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,news);
        val fabBtn: View = findViewById(R.id.fabBtn)
        fabBtn.setOnClickListener { view ->
            Snackbar.make(view, "Fetching Latest News", Snackbar.LENGTH_SHORT)
                .setAction("Action", null)
                .show()
        }

    }
}
