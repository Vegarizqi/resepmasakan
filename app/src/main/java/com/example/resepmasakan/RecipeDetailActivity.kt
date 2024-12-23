package com.example.resepmasakan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView

class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var ivRecipeImage: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvIngredients: TextView
    private lateinit var tvInstructions: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        // Inisialisasi komponen UI
        toolbar = findViewById(R.id.toolbar)
        ivRecipeImage = findViewById(R.id.ivRecipeImage)
        tvTitle = findViewById(R.id.tvTitle)
        tvIngredients = findViewById(R.id.tvIngredients)
        tvInstructions = findViewById(R.id.tvInstructions)

        // Mengambil data dari Intent
        val title = intent.getStringExtra("RECIPE_TITLE") ?: "No Title"
        val ingredients = intent.getStringExtra("RECIPE_INGREDIENTS") ?: "No Ingredients"
        val instructions = intent.getStringExtra("RECIPE_INSTRUCTIONS") ?: "No Instructions"
        val imageResId = intent.getIntExtra("RECIPE_IMAGE", 0)

        // Menampilkan data di UI
        tvTitle.text = title
        tvIngredients.text = "Bahan: $ingredients"
        tvInstructions.text = "Cara Membuat: $instructions"
        ivRecipeImage.setImageResource(imageResId)

        // Mengatur toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = title
    }
    // Tangani tombol kembali di Toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    }