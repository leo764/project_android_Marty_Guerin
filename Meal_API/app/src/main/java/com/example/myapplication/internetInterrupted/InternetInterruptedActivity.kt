package com.example.myapplication.internetInterrupted

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.area.AreaListActivity
import com.example.myapplication.category.CategoryListActivity
import com.example.myapplication.meal.MealListActivity
import com.example.myapplication.recipe.RecipeActivity
import com.example.myapplication.searchingredients.SearchIngredientActivity
import com.example.myapplication.searchname.SearchNameActivity
import okhttp3.*
import java.net.URL

class InternetInterruptedActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var refreshView: TextView

    private lateinit var goBackHomeView: TextView

    private lateinit var NoConnectionView: TextView

    private lateinit var url : URL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internetinterrupted)

        val urlString = intent?.extras?.getString("url").toString()

        recyclerView = findViewById(R.id.recycler_view)
        NoConnectionView = findViewById(R.id.titleview_name)
        refreshView = findViewById(R.id.refreshview_name)
        goBackHomeView = findViewById(R.id.gobackhomeview_name)

        refreshView.setOnClickListener {
            val context = refreshView.context

            var intent = Intent(context, MainActivity::class.java)

            if (urlString == null){
                intent = Intent(context, MainActivity::class.java)
            }

            if (urlString.equals("https://www.themealdb.com/api/json/v1/1/list.php?a=list")) {
                intent = Intent(context, AreaListActivity::class.java)
            }
            else if (urlString.equals("https://www.themealdb.com/api/json/v1/1/categories.php")) {
                intent = Intent(context, CategoryListActivity::class.java)
            }
            else if (urlString.contains("https://www.themealdb.com/api/json/v1/1/filter.php?i=")) {
                intent = Intent(context, SearchIngredientActivity::class.java)
            }
            else if (urlString.contains("https://www.themealdb.com/api/json/v1/1/search.php?s=")) {
                intent = Intent(context, SearchNameActivity::class.java)
            }
            else if (urlString.contains("https://www.themealdb.com/api/json/v1/1/filter.php?")) {
                intent = Intent(context, MealListActivity::class.java)
            }
            else if (urlString.contains("https://www.themealdb.com/api/json/v1/1/lookup.php?i=")) {
                intent = Intent(context, RecipeActivity::class.java)
            }

            if (urlString != null) {
                intent.putExtra("url", urlString)
            }
            context.startActivity(intent)
        }

        goBackHomeView.setOnClickListener {
            val context = goBackHomeView.context

            var intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
}