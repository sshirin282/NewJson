package com.example.newjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter:Adapter
    val url:String="https://api.androidhive.info/json/movies.json"
    var list:ArrayList<DataModel> = ArrayList<DataModel>()
    val i: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recylcer)



        list=ArrayList<DataModel>()
        val request: StringRequest = StringRequest(Request.Method.GET,url, Response.Listener { response ->
            Log.e("response>>>", response)
            val ja:JSONArray= JSONArray(response)
            for(i in 0 until ja.length()){
                val jsonObject:JSONObject=ja.getJSONObject(i)
                val title:String=jsonObject.getString("title")
                val rating:String=jsonObject.getString("rating")
                val releaseYear:String=jsonObject.getString("releaseYear")
                val genre:String=jsonObject.getString("genre")
                val imageUrl:String=jsonObject.getString("image")
                val dataModel=DataModel()
                dataModel.title=title
                dataModel.rating=rating
                dataModel.releaseYear=releaseYear
                dataModel.genre=genre
                dataModel.image=imageUrl
                list.add(dataModel)

            }


            adapter= Adapter(this,list)
            val layoutManager=LinearLayoutManager(this)
            recyclerView.layoutManager=layoutManager
            recyclerView.adapter=adapter



        },Response.ErrorListener {



        })
        val  requestQueue = Volley.newRequestQueue(this)
        requestQueue?.add(request)


    }
}