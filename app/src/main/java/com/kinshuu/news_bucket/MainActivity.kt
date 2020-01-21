package com.kinshuu.news_bucket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    var news_heading = arrayListOf<String>()
    var news_description = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        read_json()

        //var fabBtn: View = findViewById(R.id.fabBtn)

        fabBtn.setOnClickListener { view ->
            Snackbar.make(view, "Fetching Latest News", Snackbar.LENGTH_SHORT)
                .setAction("Action", null)
                .show()
        }
    }
    fun read_json()
    {
        var json : String? = null
        try {
            var inputStream: InputStream = assets.open("newsAPI.json")

            json = inputStream.bufferedReader().use { it.readText() }
            var jsonarr = JSONArray(json)

            for(i in 0..jsonarr.length()-1)
            {
                var jsonobj = jsonarr.getJSONObject(i)
                news_heading.add(jsonobj.getString("title"))
                news_description.add(jsonobj.getString("description"))
            }

            var listAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,news_heading)
            listView.adapter = listAdapter

            listView.setOnItemClickListener { parent, view, position, id ->
                var intent = Intent(this, detailnews::class.java)
                intent.putExtra("Heading", news_heading[position])
                intent.putExtra("Description", news_description[position])
                startActivity(intent)
            }
        }

        catch (e : IOException)
        {

        }

    }
}
