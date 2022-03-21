package com.example.csce546_project5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvContacts = findViewById<RecyclerView>(R.id.characterBios)
        val contacts: List<Character> = createBios()


        rvContacts.adapter = ContactsAdapter(this, contacts)
        rvContacts.layoutManager = LinearLayoutManager(this)
    }

    private fun createBios(): List<Character> {
        val bios: MutableList<Character> = mutableListOf()

        //Pull information from resources
        //val comicNames = resources.getStringArray(android.R.array.comic_names)
        //val comicDesc = resources.getStringArray(android.R.array.comic_descriptions)
        val charName = listOf("Bruce Wayne", "Alfred Pennyworth", "Dick Grayson", "Barbara Gordon",
            "Jason Todd", "Tim Drake", "Stephanie Brown", "Cassandra Cain", "Damian Wayne", "Duke Thomas")
        val charDescr = listOf("Batman", "Trusted Butler", "First Robin, later Nightwing", "First Batgirl, later Oracle",
        "Second Robin, later Red Hood", "Third Robin, later Red Robin", "Third Batgirl, forth Robin, later Spoiler", "Second Batgirl, Later Black Bat", 
            "Fifth Robin", "The Signal")


        for (i in charName.indices) {
            var image: Any
            when (i) {
                0 -> {
                    image = R.drawable.brucewayne
                }
                1 -> {
                    image = R.drawable.alfredpennyworth
                }
                2 -> {
                    image = R.drawable.dickgrayson
                }
                3 -> {
                    image = R.drawable.barbaragordon
                }
                4 -> {
                    image = R.drawable.jasontodd
                }
                5 -> {
                    image = R.drawable.timdrake
                }
                6 -> {
                    image = R.drawable.stephaniebrown
                }
                7 -> {
                    image = R.drawable.cassandracain
                }
                8 -> {
                    image = R.drawable.damianwayne
                }
                else -> {
                    image = R.drawable.dukethomas
                }
            }
            bios.add(Character(charName[i], charDescr[i] , image))
        }
        return bios
    }
}