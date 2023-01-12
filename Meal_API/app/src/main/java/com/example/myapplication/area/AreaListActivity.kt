package com.example.myapplication.area

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.AreasAdapter
import com.example.myapplication.AreasResponse
import com.example.myapplication.R
import com.example.myapplication.internetInterrupted.InternetInterruptedActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.net.URL

class AreaListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var areasAdapter: AreasAdapter

    private lateinit var circularProgressIndicator: CircularProgressIndicator

    private lateinit var returnButton : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area)

        recyclerView = findViewById(R.id.recycler_view)
        circularProgressIndicator = findViewById(R.id.circular_progress_indicator)
        returnButton = findViewById(R.id.return_button)

        val urlString = "https://www.themealdb.com/api/json/v1/1/list.php?a=list"
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
                    val areasResponse = gson.fromJson(it, AreasResponse::class.java)
                    areasResponse.areas?.let { it1 ->
                        runOnUiThread {
                            circularProgressIndicator.visibility = View.GONE
                            areasAdapter = AreasAdapter(it1)
                            recyclerView.adapter = areasAdapter
                            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                        }

                    }
                    Log.d("OKHTTP", "Got " + areasResponse.areas?.count() + " areas")
                }
            }
        })

        returnButton.setOnClickListener {
            finish()
        }
    }
}