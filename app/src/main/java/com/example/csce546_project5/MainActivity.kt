package com.example.csce546_project5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvContacts = findViewById<RecyclerView>(R.id.characterBios)
        val contacts: List<Character> = createContacts()

        rvContacts.adapter = MyAdapter(contacts, this)
        rvContacts.layoutManager = LinearLayoutManager(this)
    }

    private fun createContacts(): List<Character> {
        val bios: MutableList<Character> = mutableListOf()

        //Pull information from resources
        val comicNames = resources.getStringArray(R.array.comic_names)
        val comicAlias = resources.getStringArray(R.array.comic_alias)

        for (i in comicNames.indices) {
            bios.add(Character(comicNames[i], comicAlias[i], R.drawable.brucewayne))
        }
        return bios
    }

    override fun onItemClick(position: Int) {
        val comicNames = resources.getStringArray(R.array.comic_names)
        val comicAlias = resources.getStringArray(R.array.comic_alias)
        val comicDesc = resources.getStringArray(R.array.comic_descriptions)

        Toast.makeText(this, "Position $position was clicked.", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@MainActivity, Details::class.java)
        intent.putExtra("NAME", comicNames[position])
        intent.putExtra("ALIAS", comicAlias[position])
        intent.putExtra("DESC", comicDesc[position])
        intent.putExtra("IMAGE", R.drawable.brucewayne)
        startActivity(intent)
    }
}