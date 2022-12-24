package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.net.URL

class RecipeActivity : AppCompatActivity(){

    private lateinit var recyclerView: RecyclerView

    private lateinit var recipeAdapter: RecipeAdapter

    private lateinit var circularProgressIndicator: CircularProgressIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        recyclerView = findViewById(R.id.recycler_view)
        circularProgressIndicator = findViewById(R.id.circular_progress_indicator)
        val recipe_id = intent?.extras?.getString("recipe_id").toString()

        val url = URL("https://www.themealdb.com/api/json/v1/1/lookup.php?i="+recipe_id)

        val request = Request.Builder()
            .url(url)
            .build()

        val client = OkHttpClient()

        circularProgressIndicator.visibility = View.VISIBLE

        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                Log.e("OKHTTP", e.localizedMessage)
                circularProgressIndicator.visibility = View.GONE
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let {
                    val gson = Gson()
                    val recipeResponse = gson.fromJson(it, RecipeResponse::class.java)
                    recipeResponse.recipe?.let { it1 ->
                        runOnUiThread {
                            circularProgressIndicator.visibility = View.GONE
                            recipeAdapter = RecipeAdapter(it1)
                            recyclerView.adapter = recipeAdapter
                            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                        }

                    }
                    Log.d("OKHTTP", "Got " + recipeResponse.recipe?.count() + " recipe")
                }
            }
        })
    }
}