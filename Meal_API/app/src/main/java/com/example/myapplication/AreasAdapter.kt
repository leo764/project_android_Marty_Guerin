package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AreaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var nameitemView = itemView
    var nameTextView: TextView = itemView.findViewById(R.id.textview_name)
}

class AreasAdapter(val areas: List<Area>): RecyclerView.Adapter<AreaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_area, parent, false)

        return AreaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AreaViewHolder, position: Int) {
        holder.nameTextView.setText(areas.get(position).strArea)

        holder.nameitemView.setOnClickListener {
            val context = holder.nameitemView.context
            val intent = Intent(context, MealListActivity::class.java)
            intent.putExtra("category_name", "a="+areas.get(position).strArea.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return areas.count()
    }
}