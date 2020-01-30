package com.kinshuu.news_bucket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_detailnews.*

class detailnews : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailnews)

        txtNewsHeading.text = getIntent().getStringExtra("NewsHeading")
        txtNewsDescription.text = getIntent().getStringExtra("NewsDesc")

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "News Briefing"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        shareTxt.setOnClickListener {
            val s = txtNewsHeading.text.toString()
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, s)
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject here")
            startActivity(Intent.createChooser(shareIntent, "Share Via"))

        }

    }
}
