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
        val contacts: List<Character> = createContacts()


        rvContacts.adapter = ContactsAdapter(this, contacts)
        rvContacts.layoutManager = LinearLayoutManager(this)
    }

    private fun createContacts(): List<Character> {
        val bios: MutableList<Character> = mutableListOf()

        //Pull information from resources
        //val comicNames = resources.getStringArray(android.R.array.comic_names)
        //val comicDesc = resources.getStringArray(android.R.array.comic_descriptions)
        val charName = listOf(
            "Bruce Wayne",
            "Alfred Pennyworth",
            "Dick Grayson",
            "Barbara Gordon",
            "Jason Todd",
            "Tim Drake",
            "Stephanie Brown",
            "Cassandra Cain",
            "Damian Wayne",
            "Duke Thomas"
        )
        val charDescr = listOf(
            "Batman",
            "Trusted Butler",
            "First Robin, later Nightwing",
            "First Batgirl, later Oracle",
            "Second Robin, later Red Hood",
            "Third Robin, later Red Robin",
            "Third Batgirl, forth Robin, later Spoiler",
            "Second Batgirl, Later Black Bat",
            "Fifth Robin",
            "The Signal"
        )


        for (i in charName.indices) {
            bios.add(Character(charName[i], charDescr[i], R.drawable.brucewayne))
        }
        return bios
    }
}