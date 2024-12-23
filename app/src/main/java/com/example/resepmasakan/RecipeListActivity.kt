package com.example.resepmasakan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resepmasakan.adapter.RecipeAdapter
import com.example.resepmasakan.model.Recipe

class RecipeListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recipeAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        val categoryName = intent.getStringExtra("CATEGORY_NAME") ?: ""
        val recipes = getRecipesByCategory(categoryName)

        recyclerView = findViewById(R.id.recyclerViewRecipes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recipeAdapter = RecipeAdapter(this, recipes) { recipe ->
            val intent = Intent(this, RecipeDetailActivity::class.java)
            intent.putExtra("RECIPE_TITLE", recipe.title)
            intent.putExtra("RECIPE_INGREDIENTS", recipe.ingredients.joinToString(", "))
            intent.putExtra("RECIPE_INSTRUCTIONS", recipe.instructions)
            intent.putExtra("RECIPE_IMAGE", recipe.imageResId) // Mengirim ID gambar
            startActivity(intent)
        }
        recyclerView.adapter = recipeAdapter
    }

    private fun getRecipesByCategory(category: String): List<Recipe> {
        return when (category) {
            "Ayam" -> listOf(
                Recipe("Ayam Goreng", listOf("Ayam", "Minyak Goreng", "Bumbu Kuning"), "Goreng ayam hingga matang.", R.drawable.ic_ayam_goreng),
                Recipe("Ayam Bakar", listOf("Ayam", "Bumbu Kecap", "Arang"), "Bakar ayam hingga matang.", R.drawable.ic_ayam_bakar),
                Recipe("Ayam Geprek", listOf("Ayam", "Cabai", "Cobek"), "Geprek Ayam Yang sudah Digoreng bersama Samabl", R.drawable.ic_ayam_geprek)
            )
            "Padang" -> listOf(
                Recipe("Rendang", listOf("Daging Sapi", "Santan", "Bumbu Rendang"), "Masak hingga santan mengental.", R.drawable.ic_rendang),
                Recipe("Gulai Ayam", listOf("Ayam", "Santan", "Bumbu Gulai"), "Masak ayam dengan santan.", R.drawable.ic_gulai_ayam),
                Recipe("Sate Padang", listOf("Daging Sapi", "Tusuk Sate", "Bumbu khas padang"), "Tusuk Daguing dan Bakar dengan Olesan Bumbu yang khas", R.drawable.ic_sate_padang)
            )
            "Aneka Soto Nusantara" -> listOf(
                Recipe("Soto Betawi", listOf("Daging Sapi", "Santan", "Kentang"), "Masak hingga daging empuk.", R.drawable.ic_soto_betawi),
                Recipe("Soto Ayam", listOf("Ayam", "Kunyit", "Bumbu Soto"), "Rebus ayam dengan bumbu.", R.drawable.ic_soto_ayam),
                Recipe("Soto Wonosobo", listOf("Ayam", "Bumbu Soto KUning", "Santan", "Ketupat"),"Masak Ayam Dan Suwir Kecil kemudian Masak Bumbu dengan Air Sampe mendidih, tambahkan santan Campurkan kedalam mangkok dengan semuanya bahan", R.drawable.ic_soto_wonosobo)
            )
            else -> emptyList()
        }
    }
}
