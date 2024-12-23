package com.example.resepmasakan.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resepmasakan.R
import com.example.resepmasakan.RecipeListActivity
import com.example.resepmasakan.model.Category

class CategoryAdapter(
    private val context: Context,
    private val categories: List<Category>
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCategory: ImageView = itemView.findViewById(R.id.imgCategory)
        val tvCategoryName: TextView = itemView.findViewById(R.id.tvCategoryName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.tvCategoryName.text = category.name
        holder.imgCategory.setImageResource(category.imageResId)

        // Klik item kategori
        holder.itemView.setOnClickListener {
            val intent = Intent(context, RecipeListActivity::class.java)
            intent.putExtra("CATEGORY_NAME", category.name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = categories.size
}
