package com.example.myapplication.category

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CategoriesAdapter
import com.example.myapplication.CategoriesResponse
import com.example.myapplication.R
import com.example.myapplication.internetInterrupted.InternetInterruptedActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.net.URL

class CategoryListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var circularProgressIndicator: CircularProgressIndicator

    private lateinit var returnButton : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        recyclerView = findViewById(R.id.recycler_view)
        circularProgressIndicator = findViewById(R.id.circular_progress_indicator)
        returnButton = findViewById(R.id.return_button)

        val urlString = "https://www.themealdb.com/api/json/v1/1/categories.php"
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
                    val categoriesResponse = gson.fromJson(it, CategoriesResponse::class.java)
                    categoriesResponse.categories?.let { it1 ->
                        runOnUiThread {
                            circularProgressIndicator.visibility = View.GONE
                            categoriesAdapter = CategoriesAdapter(it1)
                            recyclerView.adapter = categoriesAdapter
                            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                        }

                    }
                    Log.d("OKHTTP", "Got " + categoriesResponse.categories?.count() + " categories")
                }
            }
        })

        returnButton.setOnClickListener {
            finish()
        }
    }
}