package com.example.myapplication.internetInterrupted

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.searchingredients.SearchIngredientActivity
import okhttp3.*

class InternetInterruptedActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var refreshView: TextView

    private lateinit var NoConnectionView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internetinterrupted)

        recyclerView = findViewById(R.id.recycler_view)
        NoConnectionView = findViewById(R.id.titleview_name)
        refreshView = findViewById(R.id.refreshview_name)

        refreshView.setOnClickListener {
            val context = refreshView.context
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
}