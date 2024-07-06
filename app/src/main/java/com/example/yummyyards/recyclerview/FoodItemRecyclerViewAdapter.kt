package com.example.yummyyards.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyyards.R

class FoodItemRecyclerViewAdapter(val context:Context, val arr : ArrayList<Pair<String, Int>>) : RecyclerView.Adapter<FoodItemRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.food_image_id)
        val name = itemView.findViewById<TextView>(R.id.food_name_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.food_item_layout,parent,false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(arr[position].first)
        holder.image.setImageResource(arr[position].second)
    }

    override fun getItemCount(): Int {
        return arr.size
    }
}