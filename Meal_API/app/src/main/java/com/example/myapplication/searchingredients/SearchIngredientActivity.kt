package com.example.myapplication.searchingredients

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MealsAdapter
import com.example.myapplication.MealsResponse
import com.example.myapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.net.URL

class SearchIngredientActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var searchView : TextInputEditText

    private lateinit var validateView: TextView

    private lateinit var mealsAdapter: MealsAdapter

    private lateinit var circularProgressIndicator: CircularProgressIndicator

    private lateinit var returnButton : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchname)

        recyclerView = findViewById(R.id.recycler_view)
        searchView = findViewById(R.id.searchview_name)
        validateView = findViewById(R.id.validateview_name)
        circularProgressIndicator = findViewById(R.id.circular_progress_indicator)
        returnButton = findViewById(R.id.return_button)

        val callback = object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                Log.e("OKHTTP", e.localizedMessage)
                circularProgressIndicator.visibility = View.GONE
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let {
                    val gson = Gson()
                    val mealResponse = gson.fromJson(it, MealsResponse::class.java)
                    mealResponse.meals?.let { it1 ->
                        runOnUiThread {
                            circularProgressIndicator.visibility = View.GONE
                            mealsAdapter = MealsAdapter(it1)
                            recyclerView.adapter = mealsAdapter
                            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                        }

                    }
                    Log.d("OKHTTP", "Got " + mealResponse.meals?.count() + " meal")
                }
            }
        }

        validateView.setOnClickListener {

            circularProgressIndicator.visibility = View.VISIBLE

            val url = URL("https://www.themealdb.com/api/json/v1/1/filter.php?i="+searchView.text.toString())

            val request = Request.Builder()
                .url(url)
                .build()

            val client = OkHttpClient()

            client.newCall(request).enqueue(callback)
        }

        returnButton.setOnClickListener {
            finish()
        }
    }
}