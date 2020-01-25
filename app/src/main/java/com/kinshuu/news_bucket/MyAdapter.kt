package com.kinshuu.news_bucket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.news_list_item.view.*

class MyAdapter(var items : ArrayList<News>, var clickListner: OnNewsItemClickListner) : RecyclerView.Adapter<NewsViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        lateinit var newsViewHolder : NewsViewHolder
        newsViewHolder = NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_list_item,parent,false ))
        return newsViewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        holder.initialize(items.get(position),clickListner)

    }
}

class NewsViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
    var headline = itemView.txtHeadNews
    //var description = itemView.txtDescNews

    fun initialize(item: News, action:OnNewsItemClickListner){
        headline.text = item.Headline
        //description.text = item.Description

        itemView.setOnClickListener{
            action.onItemClick(item,adapterPosition)
        }

    }

}

interface OnNewsItemClickListner{
    fun onItemClick(item: News, position: Int)
}