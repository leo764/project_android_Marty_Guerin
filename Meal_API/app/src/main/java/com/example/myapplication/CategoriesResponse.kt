package com.example.myapplication

import com.google.gson.annotations.SerializedName

class CategoriesResponse {

    var count: Int? = null
    var previous: String? = null
    var next: String? = null

    @SerializedName("categories")
    var categories: List<Category>? = null
}

class Category {

    var strCategory: String? = null


}