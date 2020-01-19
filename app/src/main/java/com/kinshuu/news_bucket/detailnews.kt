package com.kinshuu.news_bucket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detailnews.*

class detailnews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailnews)
        val bundle: Bundle? = intent.extras
        val news_heading: String? = bundle?.getString("Heading")
        val news_Description: String? = bundle?.getString("Description")

        txtNewsHeading.setText(news_heading.toString())
        txtNewsDescription.setText(news_Description.toString())
    }
}
