package com.example.myapplication

import android.net.Uri
import com.google.gson.annotations.SerializedName
import java.net.URI

class CategoriesResponse {

    var count: Int? = null
    var previous: String? = null
    var next: String? = null

    @SerializedName("categories")
    var categories: List<Category>? = null
}

class Category {

    var idCategory: Int? = null
    var strCategory: String? = null
    var strCategoryThumb: String? = null
    var strCategoryDescription: String? = null

}