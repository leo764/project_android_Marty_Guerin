package com.example.myapplication.recipe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.RecipeAdapter
import com.example.myapplication.RecipeResponse
import com.example.myapplication.category.CategoryListActivity
import com.example.myapplication.internetInterrupted.InternetInterruptedActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.net.URL

class RecipeActivity : AppCompatActivity(){

    private lateinit var recyclerView: RecyclerView

    private lateinit var recipeAdapter: RecipeAdapter

    private lateinit var circularProgressIndicator: CircularProgressIndicator

    private lateinit var returnButton : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        recyclerView = findViewById(R.id.recycler_view)
        circularProgressIndicator = findViewById(R.id.circular_progress_indicator)
        returnButton = findViewById(R.id.return_button)

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

                runOnUiThread {
                    circularProgressIndicator.visibility = View.GONE
                    val intent =
                        Intent(recyclerView.context, InternetInterruptedActivity::class.java)
                    recyclerView.context.startActivity(intent)
                }
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

        returnButton.setOnClickListener {
            finish()
        }
    }
}