package com.example.myapplication

import com.google.gson.annotations.SerializedName

class MealsResponse {

    var count: Int? = null
    var previous: String? = null
    var next: String? = null

    @SerializedName("meals")
    var meals: List<Meal>? = null
}

class Meal {

    var idMeal: Int? = null
    var strMeal: String? = null
    var strMealThumb: String? = null

}