package com.kinshuu.news_bucket

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detailnews.*
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() ,OnNewsItemClickListner {
    lateinit var newslist: ArrayList<News>
    lateinit var txtNewsHeading: TextView
    lateinit var shareFab : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newslist = ArrayList()
        addNews()

        val fabBtn: View = findViewById(R.id.fabBtn)
        fabBtn.setOnClickListener { view ->
            Snackbar.make(view, "Fetching Latest News", Snackbar.LENGTH_SHORT)
                .setAction("Action", null)
                .show()
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this,1))
        recyclerView.adapter = MyAdapter(newslist,this)

    }
    fun addNews(){
        newslist.add(News("Toyota","good car, good car, good car, good car, good car, good car, good car, good car, good car, good car", R.drawable.logo_news_bucket) )
        newslist.add(News("Hyundai","good car, good car, good car, good car, good car, good car, good car, good car, good car, good car", R.drawable.logo_news_bucket) )
        newslist.add(News("Marcedese","good car, good car, good car, good car, good car, good car, good car, good car, good car, good car", R.drawable.logo_news_bucket) )
        newslist.add(News("Bentley","good car, good car, good car, good car, good car, good car, good car, good car, good car, good car", R.drawable.logo_news_bucket) )
        newslist.add(News("Nissan","good car, good car, good car, good car, good car, good car, good car, good car, good car, good car", R.drawable.logo_news_bucket) )
        newslist.add(News("Ford","good car, good car, good car, good car, good car, good car, good car, good car, good car, good car", R.drawable.logo_news_bucket) )

    }


    override fun onItemClick(item: News, position: Int) {

        val intent = Intent(this, detailnews::class.java)
        intent.putExtra("NewsHeading", item.Headline)
        intent.putExtra("NewsDesc", item.Description)
        startActivity(intent)
    }





}
