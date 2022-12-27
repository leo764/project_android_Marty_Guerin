package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.meal.MealListActivity
import com.squareup.picasso.Picasso


class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var nameitemView = itemView
    var nameTextView: TextView = itemView.findViewById(R.id.textview_name)
    var nameImageView: ImageView = itemView.findViewById(R.id.imageview_name)
}

class CategoriesAdapter(val categories: List<Category>): RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)

        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.nameTextView.setText(categories.get(position).strCategory)
        Picasso.get().load(categories.get(position).strCategoryThumb).into(holder.nameImageView)

        holder.nameitemView.setOnClickListener {
            val context = holder.nameitemView.context
            val intent = Intent(context, MealListActivity::class.java)
            intent.putExtra("category_name","c="+categories.get(position).strCategory.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return categories.count()
    }
}