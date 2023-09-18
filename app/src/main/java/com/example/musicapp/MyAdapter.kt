package com.example.musicapp

import android.app.Activity
import android.media.Image
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val datalist :List<Data>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
         return  datalist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentdata=datalist[position]

        val mediaPlayer=MediaPlayer.create(context,currentdata.preview.toUri())
        holder.Title.text =currentdata.title
        Picasso.get().load(currentdata.album.cover).into(holder.Image)
        holder.play.setOnClickListener(){
            mediaPlayer.start()
        }
        holder.pause.setOnClickListener(){
            mediaPlayer.stop()
        }

    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val Image: ImageView
        val Title :TextView
        val pause: ImageButton
        val play : ImageButton

        init {
            Image=itemView.findViewById(R.id.musicimage)
            Title=itemView.findViewById(R.id.musictitle)
            pause=itemView.findViewById(R.id.btnpause)
            play=itemView.findViewById(R.id.btnplay)
        }
    }

}