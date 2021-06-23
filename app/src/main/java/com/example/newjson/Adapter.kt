package com.example.newjson

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context, val  list:ArrayList<DataModel> )
    :RecyclerView.Adapter<Adapter.ViewHolder>() {
    private val inflater:LayoutInflater
    =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val textView1:TextView=view.findViewById(R.id.text1)
        val textView2:TextView=view.findViewById(R.id.text2)
        val textView3:TextView=view.findViewById(R.id.text3)
        val textView4:TextView=view.findViewById(R.id.text4)
        val imageView:ImageView=view.findViewById(R.id.image1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
      val rowList=inflater.inflate(R.layout.list,parent,false)
        return ViewHolder(rowList)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
       holder.textView1.text=list.get(position).title
        holder.textView2.text=list.get(position).rating
        holder.textView3.text=list.get(position).releaseYear
        holder.textView4.text=list.get(position).genre
        Glide.with(context)
            .load(list.get(position).image)
            .into(holder.imageView)

    }

}