package com.example.myapplication

import com.google.gson.annotations.SerializedName

class RecipeResponse {

    var count: Int? = null
    var previous: String? = null
    var next: String? = null

    @SerializedName("meals")
    var recipe: List<Recipe>? = null
}

class Recipe {

    var idMeal: Int? = null
    var strMeal: String? = null
    var strInstructions: String? = null
    var strMealThumb: String? = null
    var strYoutube: String? = null
    var strIngredient1: String? = ""
    var strIngredient2: String? = ""
    var strIngredient3: String? = ""
    var strIngredient4: String? = ""
    var strIngredient5: String? = ""
    var strIngredient6: String? = ""
    var strIngredient7: String? = ""
    var strIngredient8: String? = ""
    var strIngredient9: String? = ""
    var strIngredient10: String? = ""
    var strIngredient11: String? = ""
    var strIngredient12: String? = ""
    var strIngredient13: String? = ""
    var strIngredient14: String? = ""
    var strIngredient15: String? = ""
    var strIngredient16: String? = ""
    var strIngredient17: String? = ""
    var strIngredient18: String? = ""
    var strIngredient19: String? = ""
    var strIngredient20: String? = ""
    var strMeasure1: String? = null
    var strMeasure2: String? = null
    var strMeasure3: String? = null
    var strMeasure4: String? = null
    var strMeasure5: String? = null
    var strMeasure6: String? = null
    var strMeasure7: String? = null
    var strMeasure8: String? = null
    var strMeasure9: String? = null
    var strMeasure10: String? = null
    var strMeasure11: String? = null
    var strMeasure12: String? = null
    var strMeasure13: String? = null
    var strMeasure14: String? = null
    var strMeasure15: String? = null
    var strMeasure16: String? = null
    var strMeasure17: String? = null
    var strMeasure18: String? = null
    var strMeasure19: String? = null
    var strMeasure20: String? = null
}

