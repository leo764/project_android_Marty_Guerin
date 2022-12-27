package com.example.myapplication

import com.google.gson.annotations.SerializedName

class AreasResponse {

    var count: Int? = null
    var previous: String? = null
    var next: String? = null

    @SerializedName("meals")
    var areas: List<Area>? = null
}

class Area {

    var strArea: String? = null
}