package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import okhttp3.*
import java.io.IOException
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var exploreView: TextView

    private lateinit var tryView: TextView

    private lateinit var randomView: TextView

    private lateinit var imageView: ImageView

    private lateinit var searchNameView : TextView

    private lateinit var circularProgressIndicator: CircularProgressIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        exploreView = findViewById(R.id.exploreview_name)
        tryView = findViewById(R.id.tryview_name)
        randomView = findViewById(R.id.randomview_name)
        imageView = findViewById(R.id.imageview_name)
        circularProgressIndicator = findViewById(R.id.circular_progress_indicator)
        searchNameView = findViewById(R.id.searchnameview_name)

        val url = URL("https://www.themealdb.com/api/json/v1/1/random.php")

        val request = Request.Builder()
            .url(url)
            .build()

        val client = OkHttpClient()

        circularProgressIndicator.visibility = View.VISIBLE
        tryView.visibility = View.GONE

        val callback = object : Callback {

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
                            tryView.visibility = View.VISIBLE
                            Picasso.get().load(it1.get(0).strMealThumb).into(imageView)

                            tryView.setOnClickListener {
                                val context = tryView.context
                                val intent = Intent(context, RecipeActivity::class.java)
                                intent.putExtra("recipe_id", it1.get(0).idMeal.toString())
                                context.startActivity(intent)
                            }
                        }

                    }
                    Log.d("OKHTTP", "Got " + recipeResponse.recipe?.count() + " recipe")
                }
            }
        }

        client.newCall(request).enqueue(callback)

        exploreView.setOnClickListener {
            val context = exploreView.context
            val intent = Intent(context, CategoryListActivity::class.java)
            context.startActivity(intent)
        }

        randomView.setOnClickListener {
            circularProgressIndicator.visibility = View.VISIBLE
            tryView.visibility = View.GONE
            client.newCall(request).enqueue(callback)
        }

        searchNameView.setOnClickListener {
            val context = searchNameView.context
            val intent = Intent(context, SearchNameActivity::class.java)
            context.startActivity(intent)
        }

    }
}