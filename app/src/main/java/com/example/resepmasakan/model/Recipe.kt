package com.example.resepmasakan.model

data class Recipe(
    val title: String,
    val ingredients: List<String>,
    val instructions: String,
    val imageResId: Int // Menambahkan properti untuk menyimpan ID gambar
)
