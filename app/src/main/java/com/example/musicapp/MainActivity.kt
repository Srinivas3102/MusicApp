package com.example.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
 

class MainActivity : AppCompatActivity() {


    lateinit var myRecyclerview : RecyclerView
    lateinit var myadapter : MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerview=findViewById(R.id.recycler_view)

        val retrofitbuilder=Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)


        val retrofitdata=retrofitbuilder.getData("eminem")

        retrofitdata.enqueue(object : Callback<Mydata?> {
            override fun onResponse(call: Call<Mydata?>, response: Response<Mydata?>) {
                val datalist=response.body()?.data!!
                //val tv=findViewById<TextView>(R.id.tv)
                //tv.text=datalist.toString()

                myadapter= MyAdapter(this@MainActivity, datalist)
                myRecyclerview.adapter=myadapter
                myRecyclerview.layoutManager=LinearLayoutManager(this@MainActivity)
                Log.d("TAG:onResponse", "onResponse:"+ response.body())
            }

            override fun onFailure(call: Call<Mydata?>, t: Throwable) {
                Log.d("TAG:onFailure", "onFailure:"+ t.message)
            }
        })
    }
}