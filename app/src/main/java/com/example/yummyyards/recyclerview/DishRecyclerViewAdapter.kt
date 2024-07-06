package com.example.yummyyards.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.yummyyards.R
import com.example.yummyyards.fragments.TimePickerBottomSheetDialogFragment
import com.example.yummyyards.models.Dish
import com.squareup.picasso.Picasso


class DishRecyclerViewAdapter(val context: Context, var arr : List<Dish>) : RecyclerView.Adapter<DishRecyclerViewAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val foodImage = itemView.findViewById<ImageView>(R.id.dish_image)
            val foodName = itemView.findViewById<TextView>(R.id.dish_name)
            val foodBody = itemView.findViewById<CardView>(R.id.food_body)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.dish_layout,parent,false)
            val viewHolder = ViewHolder(view)
            return viewHolder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val x = arr[position]
            Picasso.get().load(x.imageUrl).into(holder.foodImage)
            holder.foodName.text = x.dishName
            holder.foodBody.setOnClickListener {
                showTimePickerBottomSheet()
            }
        }

        override fun getItemCount(): Int {
            return arr.size
        }
    fun setDishes(dishes: List<Dish>) {
        this.arr = dishes
        notifyDataSetChanged()
    }

    private fun showTimePickerBottomSheet() {
        val bottomSheetFragment = TimePickerBottomSheetDialogFragment()
        bottomSheetFragment.setOnTimePickedListener { selectedTime ->
            // Handle the selected time (e.g., update UI, send data, etc.)
            // For now, let's log it
            Log.d("selectedtime","$selectedTime")
        }
        bottomSheetFragment.show(
            (context as AppCompatActivity).supportFragmentManager,
            bottomSheetFragment.tag
        )
    }
}
