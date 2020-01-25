package com.kinshuu.news_bucket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detailnews.*

class detailnews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailnews)

        txtNewsHeading.text = getIntent().getStringExtra("NewsHeading")
        txtNewsDescription.text = getIntent().getStringExtra("NewsDesc")

    }
}
