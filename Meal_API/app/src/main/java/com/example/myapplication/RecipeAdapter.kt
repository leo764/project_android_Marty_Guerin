package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var nameTextView: TextView = itemView.findViewById(R.id.titleview_name)
    var nameImageView: ImageView = itemView.findViewById(R.id.imageview_name)
    var instructionTextView: TextView = itemView.findViewById(R.id.instructionview_name)
    var linkTextView: TextView = itemView.findViewById(R.id.linkview_name)
    var ingredientTextView: TextView = itemView.findViewById(R.id.ingredientview_name)
    var measureTextView: TextView = itemView.findViewById(R.id.measureview_name)
}

class RecipeAdapter(val recipe: List<Recipe>): RecyclerView.Adapter<RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)

        return RecipeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position : Int) {
        holder.nameTextView.setText(recipe.get(position).strMeal)
        Picasso.get().load(recipe.get(position).strMealThumb).into(holder.nameImageView)
        holder.instructionTextView.setText(recipe.get(position).strInstructions)

        val link = recipe.get(position).strYoutube
        if (link != null) {
            holder.linkTextView.setText(link)
        }

        holder.ingredientTextView.setText(getIngredientList(recipe.get(position)))
        holder.measureTextView.setText(getMeasureList(recipe.get(position)))
    }

    override fun getItemCount(): Int {
        return recipe.count()
    }

    fun getIngredientList(recipe : Recipe): String {

        if (recipe.strIngredient20 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6 +"\n- "+recipe.strIngredient7 +"\n- "+recipe.strIngredient8 +"\n- "+recipe.strIngredient9 +"\n- "+recipe.strIngredient10 +"\n- "+recipe.strIngredient11 +"\n- "+recipe.strIngredient12 +"\n- "+recipe.strIngredient13 +"\n- "+recipe.strIngredient14 +"\n- "+recipe.strIngredient15 +"\n- "+recipe.strIngredient16 +"\n- "+recipe.strIngredient17 +"\n- "+recipe.strIngredient18 +"\n- "+recipe.strIngredient19 +"\n- "+recipe.strIngredient20
        }
        else if (recipe.strIngredient19 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6 +"\n- "+recipe.strIngredient7 +"\n- "+recipe.strIngredient8 +"\n- "+recipe.strIngredient9 +"\n- "+recipe.strIngredient10 +"\n- "+recipe.strIngredient11 +"\n- "+recipe.strIngredient12 +"\n- "+recipe.strIngredient13 +"\n- "+recipe.strIngredient14 +"\n- "+recipe.strIngredient15 +"\n- "+recipe.strIngredient16 +"\n- "+recipe.strIngredient17 +"\n- "+recipe.strIngredient18 +"\n- "+recipe.strIngredient19
        }
        else if (recipe.strIngredient18 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6 +"\n- "+recipe.strIngredient7 +"\n- "+recipe.strIngredient8 +"\n- "+recipe.strIngredient9 +"\n- "+recipe.strIngredient10 +"\n- "+recipe.strIngredient11 +"\n- "+recipe.strIngredient12 +"\n- "+recipe.strIngredient13 +"\n- "+recipe.strIngredient14 +"\n- "+recipe.strIngredient15 +"\n- "+recipe.strIngredient16 +"\n- "+recipe.strIngredient17 +"\n- "+recipe.strIngredient18
        }
        else if (recipe.strIngredient17 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6 +"\n- "+recipe.strIngredient7 +"\n- "+recipe.strIngredient8 +"\n- "+recipe.strIngredient9 +"\n- "+recipe.strIngredient10 +"\n- "+recipe.strIngredient11 +"\n- "+recipe.strIngredient12 +"\n- "+recipe.strIngredient13 +"\n- "+recipe.strIngredient14 +"\n- "+recipe.strIngredient15 +"\n- "+recipe.strIngredient16 +"\n- "+recipe.strIngredient17
        }
        else if (recipe.strIngredient16 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6 +"\n- "+recipe.strIngredient7 +"\n- "+recipe.strIngredient8 +"\n- "+recipe.strIngredient9 +"\n- "+recipe.strIngredient10 +"\n- "+recipe.strIngredient11 +"\n- "+recipe.strIngredient12 +"\n- "+recipe.strIngredient13 +"\n- "+recipe.strIngredient14 +"\n- "+recipe.strIngredient15 +"\n- "+recipe.strIngredient16
        }
        else if (recipe.strIngredient15 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6 +"\n- "+recipe.strIngredient7 +"\n- "+recipe.strIngredient8 +"\n- "+recipe.strIngredient9 +"\n- "+recipe.strIngredient10 +"\n- "+recipe.strIngredient11 +"\n- "+recipe.strIngredient12 +"\n- "+recipe.strIngredient13 +"\n- "+recipe.strIngredient14 +"\n- "+recipe.strIngredient15
        }
        else if (recipe.strIngredient14 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6 +"\n- "+recipe.strIngredient7 +"\n- "+recipe.strIngredient8 +"\n- "+recipe.strIngredient9 +"\n- "+recipe.strIngredient10 +"\n- "+recipe.strIngredient11 +"\n- "+recipe.strIngredient12 +"\n- "+recipe.strIngredient13 +"\n- "+recipe.strIngredient14
        }
        else if (recipe.strIngredient13 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6 +"\n- "+recipe.strIngredient7 +"\n- "+recipe.strIngredient8 +"\n- "+recipe.strIngredient9 +"\n- "+recipe.strIngredient10 +"\n- "+recipe.strIngredient11 +"\n- "+recipe.strIngredient12 +"\n- "+recipe.strIngredient13
        }
        else if (recipe.strIngredient12 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6 +"\n- "+recipe.strIngredient7 +"\n- "+recipe.strIngredient8 +"\n- "+recipe.strIngredient9 +"\n- "+recipe.strIngredient10 +"\n- "+recipe.strIngredient11 +"\n- "+recipe.strIngredient12
        }
        else if (recipe.strIngredient11 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6 +"\n- "+recipe.strIngredient7 +"\n- "+recipe.strIngredient8 +"\n- "+recipe.strIngredient9 +"\n- "+recipe.strIngredient10 +"\n- "+recipe.strIngredient11
        }
        else if (recipe.strIngredient10 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6 +"\n- "+recipe.strIngredient7 +"\n- "+recipe.strIngredient8 +"\n- "+recipe.strIngredient9 +"\n- "+recipe.strIngredient10
        }
        else if (recipe.strIngredient9 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6 +"\n- "+recipe.strIngredient7 +"\n- "+recipe.strIngredient8 +"\n- "+recipe.strIngredient9
        }
        else if (recipe.strIngredient8 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6 +"\n- "+recipe.strIngredient7 +"\n- "+recipe.strIngredient8
        }
        else if (recipe.strIngredient7 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6 +"\n- "+recipe.strIngredient7
        }
        else if (recipe.strIngredient6 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5 +"\n- "+recipe.strIngredient6
        }
        else if (recipe.strIngredient5 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4 +"\n- "+recipe.strIngredient5
        }
        else if (recipe.strIngredient4 != ""){
            return "- "+recipe.strIngredient1+"\n- "+recipe.strIngredient2 +"\n- "+recipe.strIngredient3 +"\n- "+recipe.strIngredient4
        }
        else if (recipe.strIngredient3 != "") {
            return "- " + recipe.strIngredient1 + "\n- " + recipe.strIngredient2 + "\n- " + recipe.strIngredient3
        }
        else if (recipe.strIngredient2 != "") {
            return "- " + recipe.strIngredient1 + "\n- " + recipe.strIngredient2
        }
        else if (recipe.strIngredient1 != "") {
            return "- " + recipe.strIngredient1
        }
        else {
            return ""
        }
    }

    fun getMeasureList(recipe : Recipe): String {

        if (recipe.strMeasure20 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6 +"\n"+recipe.strMeasure7 +"\n"+recipe.strMeasure8 +"\n"+recipe.strMeasure9 +"\n"+recipe.strMeasure10 +"\n"+recipe.strMeasure11 +"\n"+recipe.strMeasure12 +"\n"+recipe.strMeasure13 +"\n"+recipe.strMeasure14 +"\n"+recipe.strMeasure15 +"\n"+recipe.strMeasure16 +"\n"+recipe.strMeasure17 +"\n"+recipe.strMeasure18 +"\n"+recipe.strMeasure19 +"\n"+recipe.strMeasure20
        }
        else if (recipe.strMeasure19 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6 +"\n"+recipe.strMeasure7 +"\n"+recipe.strMeasure8 +"\n"+recipe.strMeasure9 +"\n"+recipe.strMeasure10 +"\n"+recipe.strMeasure11 +"\n"+recipe.strMeasure12 +"\n"+recipe.strMeasure13 +"\n"+recipe.strMeasure14 +"\n"+recipe.strMeasure15 +"\n"+recipe.strMeasure16 +"\n"+recipe.strMeasure17 +"\n"+recipe.strMeasure18 +"\n"+recipe.strMeasure19
        }
        else if (recipe.strMeasure18 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6 +"\n"+recipe.strMeasure7 +"\n"+recipe.strMeasure8 +"\n"+recipe.strMeasure9 +"\n"+recipe.strMeasure10 +"\n"+recipe.strMeasure11 +"\n"+recipe.strMeasure12 +"\n"+recipe.strMeasure13 +"\n"+recipe.strMeasure14 +"\n"+recipe.strMeasure15 +"\n"+recipe.strMeasure16 +"\n"+recipe.strMeasure17 +"\n"+recipe.strMeasure18
        }
        else if (recipe.strMeasure17 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6 +"\n"+recipe.strMeasure7 +"\n"+recipe.strMeasure8 +"\n"+recipe.strMeasure9 +"\n"+recipe.strMeasure10 +"\n"+recipe.strMeasure11 +"\n"+recipe.strMeasure12 +"\n"+recipe.strMeasure13 +"\n"+recipe.strMeasure14 +"\n"+recipe.strMeasure15 +"\n"+recipe.strMeasure16 +"\n"+recipe.strMeasure17
        }
        else if (recipe.strMeasure16 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6 +"\n"+recipe.strMeasure7 +"\n"+recipe.strMeasure8 +"\n"+recipe.strMeasure9 +"\n"+recipe.strMeasure10 +"\n"+recipe.strMeasure11 +"\n"+recipe.strMeasure12 +"\n"+recipe.strMeasure13 +"\n"+recipe.strMeasure14 +"\n"+recipe.strMeasure15 +"\n"+recipe.strMeasure16
        }
        else if (recipe.strMeasure15 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6 +"\n"+recipe.strMeasure7 +"\n"+recipe.strMeasure8 +"\n"+recipe.strMeasure9 +"\n"+recipe.strMeasure10 +"\n"+recipe.strMeasure11 +"\n"+recipe.strMeasure12 +"\n"+recipe.strMeasure13 +"\n"+recipe.strMeasure14 +"\n"+recipe.strMeasure15
        }
        else if (recipe.strMeasure14 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6 +"\n"+recipe.strMeasure7 +"\n"+recipe.strMeasure8 +"\n"+recipe.strMeasure9 +"\n"+recipe.strMeasure10 +"\n"+recipe.strMeasure11 +"\n"+recipe.strMeasure12 +"\n"+recipe.strMeasure13 +"\n"+recipe.strMeasure14
        }
        else if (recipe.strMeasure13 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6 +"\n"+recipe.strMeasure7 +"\n"+recipe.strMeasure8 +"\n"+recipe.strMeasure9 +"\n"+recipe.strMeasure10 +"\n"+recipe.strMeasure11 +"\n"+recipe.strMeasure12 +"\n"+recipe.strMeasure13
        }
        else if (recipe.strMeasure12 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6 +"\n"+recipe.strMeasure7 +"\n"+recipe.strMeasure8 +"\n"+recipe.strMeasure9 +"\n"+recipe.strMeasure10 +"\n"+recipe.strMeasure11 +"\n"+recipe.strMeasure12
        }
        else if (recipe.strMeasure11 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6 +"\n"+recipe.strMeasure7 +"\n"+recipe.strMeasure8 +"\n"+recipe.strMeasure9 +"\n"+recipe.strMeasure10 +"\n"+recipe.strMeasure11
        }
        else if (recipe.strMeasure10 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6 +"\n"+recipe.strMeasure7 +"\n"+recipe.strMeasure8 +"\n"+recipe.strMeasure9 +"\n"+recipe.strMeasure10
        }
        else if (recipe.strMeasure9 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6 +"\n"+recipe.strMeasure7 +"\n"+recipe.strMeasure8 +"\n"+recipe.strMeasure9
        }
        else if (recipe.strMeasure8 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6 +"\n"+recipe.strMeasure7 +"\n"+recipe.strMeasure8
        }
        else if (recipe.strMeasure7 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6 +"\n"+recipe.strMeasure7
        }
        else if (recipe.strMeasure6 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5 +"\n"+recipe.strMeasure6
        }
        else if (recipe.strMeasure5 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4 +"\n"+recipe.strMeasure5
        }
        else if (recipe.strMeasure4 != ""){
            return ""+recipe.strMeasure1+"\n"+recipe.strMeasure2 +"\n"+recipe.strMeasure3 +"\n"+recipe.strMeasure4
        }
        else if (recipe.strMeasure3 != "") {
            return "" + recipe.strMeasure1 + "\n" + recipe.strMeasure2 + "\n" + recipe.strMeasure3
        }
        else if (recipe.strMeasure2 != "") {
            return "" + recipe.strMeasure1 + "\n" + recipe.strMeasure2
        }
        else if (recipe.strMeasure1 != "") {
            return "" + recipe.strMeasure1
        }
        else {
            return ""
        }
    }
}