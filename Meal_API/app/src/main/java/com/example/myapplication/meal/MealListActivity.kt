package com.example.myapplication.meal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MealsAdapter
import com.example.myapplication.MealsResponse
import com.example.myapplication.R
import com.example.myapplication.internetInterrupted.InternetInterruptedActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.net.URL

class MealListActivity : AppCompatActivity(), java.io.Serializable {

    private lateinit var recyclerView: RecyclerView

    private lateinit var mealsAdapter: MealsAdapter

    private lateinit var circularProgressIndicator: CircularProgressIndicator

    private lateinit var returnButton : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_list)

        recyclerView = findViewById(R.id.recycler_view_meal_list)
        circularProgressIndicator = findViewById(R.id.circular_progress_indicator_meal_list)
        returnButton = findViewById(R.id.return_button)

        val category_name = intent?.extras?.getString("category_name").toString()
        var urlString = intent?.extras?.getString("url").toString()

        if (! urlString.contains("https://www.themealdb.com/api/json/v1/1/filter.php?")) {
            urlString = "https://www.themealdb.com/api/json/v1/1/filter.php?" + category_name
        }

        val url = URL(urlString)

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
                    intent.putExtra("url", urlString)
                    finish()
                    recyclerView.context.startActivity(intent)
                }
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let {
                    val gson = Gson()
                    val mealsResponse = gson.fromJson(it, MealsResponse::class.java)
                    mealsResponse.meals?.let { it1 ->
                        runOnUiThread {
                            circularProgressIndicator.visibility = View.GONE
                            mealsAdapter = MealsAdapter(it1)
                            recyclerView.adapter = mealsAdapter
                            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                        }

                    }
                    Log.d("OKHTTP", "Got " + mealsResponse.meals?.count() + " meals")
                }
            }
        })

        returnButton.setOnClickListener {
            finish()
        }
    }
}