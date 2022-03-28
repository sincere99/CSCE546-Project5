package com.example.csce546_project5

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_card)

        //Pull information from main activity
        val name = intent.getStringExtra("NAME")
        val alias = intent.getStringExtra("ALIAS")
        val description = intent.getStringExtra("DESC")
        val image = intent.getIntExtra("IMAGE", 0)

        //Create text and image views
        val tvName: TextView = findViewById(R.id.tv_Name)
        val tvAlias: TextView = findViewById(R.id.tv_Alias)
        val tvDesc: TextView = findViewById(R.id.tv_description)
        val ivImage: ImageView = findViewById(R.id.iv_Image)

        //Place information in text and image views
        tvName.text = name
        tvAlias.text = alias
        tvDesc.text = description
        ivImage.setImageResource(image)
    }
}