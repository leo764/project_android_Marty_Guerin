package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.recipe.RecipeActivity
import com.squareup.picasso.Picasso

class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var nameitemView = itemView
    var nameTextView: TextView = itemView.findViewById(R.id.textviewmeal_name)
    var nameImageView: ImageView = itemView.findViewById(R.id.imageviewmeal_name)
}

class MealsAdapter(val meals: List<Meal>): RecyclerView.Adapter<MealViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false)

        return MealViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.nameTextView.setText(meals.get(position).strMeal)
        Picasso.get().load(meals.get(position).strMealThumb).into(holder.nameImageView)

        holder.nameitemView.setOnClickListener {
            val context = holder.nameitemView.context
            val intent = Intent(context, RecipeActivity::class.java)
            intent.putExtra("recipe_id", meals.get(position).idMeal.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return meals.count()
    }
}