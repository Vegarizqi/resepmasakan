package com.example.resepmasakan.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.resepmasakan.R
import com.example.resepmasakan.RecipeListActivity

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Mengembalikan layout untuk fragment_home
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Misalnya, jika Anda memiliki tombol untuk membuka daftar resep
        val buttonAyam = view.findViewById<Button>(R.id.buttonAyam)
        buttonAyam.setOnClickListener {
            val intent = Intent(activity, RecipeListActivity::class.java)
            intent.putExtra("CATEGORY_NAME", "Ayam") // Mengirim nama kategori
            startActivity(intent)
        }

        // Tambahkan tombol lain untuk kategori lainnya jika diperlukan
        val buttonPadang = view.findViewById<Button>(R.id.buttonPadang)
        buttonPadang.setOnClickListener {
            val intent = Intent(activity, RecipeListActivity::class.java)
            intent.putExtra("CATEGORY_NAME", "Padang") // Mengirim nama kategori
            startActivity(intent)
        }

        val buttonSoto = view.findViewById<Button>(R.id.buttonSoto)
        buttonSoto.setOnClickListener {
            val intent = Intent(activity, RecipeListActivity::class.java)
            intent.putExtra("CATEGORY_NAME", "Aneka Soto Nusantara") // Mengirim nama kategori
            startActivity(intent)
        }
    }
}