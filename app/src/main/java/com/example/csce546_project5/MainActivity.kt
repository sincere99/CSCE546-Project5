package com.example.csce546_project5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {
    private var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize views
        drawerLayout = findViewById(R.id.drawer_layout)

        val rvContacts = findViewById<RecyclerView>(R.id.characterBios)
        val contacts: List<Character> = createContacts()

        rvContacts.adapter = MyAdapter(contacts, this)
        rvContacts.layoutManager = LinearLayoutManager(this)
    }

    //Create bio of characters
    private fun createContacts(): List<Character> {
        val bios: MutableList<Character> = mutableListOf()

        //Pull information from resources
        val comicNames = resources.getStringArray(R.array.comic_names)
        val comicAlias = resources.getStringArray(R.array.comic_alias)

        //Add character info to bio
        for (i in comicNames.indices) {
            bios.add(Character(comicNames[i], comicAlias[i], R.drawable.brucewayne))
        }
        return bios
    }

    //When character card is clicked
    override fun onItemClick(position: Int) {
        //Pull information from resources
        val comicNames = resources.getStringArray(R.array.comic_names)
        val comicAlias = resources.getStringArray(R.array.comic_alias)
        val comicDesc = resources.getStringArray(R.array.comic_descriptions)

        //Indicate the position clicked
        Toast.makeText(this, "Position $position was clicked.", Toast.LENGTH_SHORT).show()

        //Pass character info over to detail activity
        val intent = Intent(this@MainActivity, Details::class.java)
        intent.putExtra("NAME", comicNames[position])
        intent.putExtra("ALIAS", comicAlias[position])
        intent.putExtra("DESC", comicDesc[position])
        intent.putExtra("IMAGE", R.drawable.brucewayne)
        startActivity(intent)
    }


    //Click menu to open drawer
    fun clickMenu(view: View?) {
        openDrawer(drawerLayout!!)
    }

    //Open drawer layout
    private fun openDrawer(drawerLayout: DrawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START)
    }

    //Close drawer layout
    private fun closeDrawer(drawerLayout: DrawerLayout) {
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    //Redirect from one activity to another
    private fun redirectActivity(activity: Activity, aClass: Class<*>?) {
        //Initialize intent
        val intent = Intent(activity, aClass)
        //Set flag
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        //Start activity
        activity.startActivity(intent)
    }

    //Recreate the Recycler view activity
    fun clickRecyclerView(view: View?) {
        recreate()
    }

    //Redirect to Fragments activity
    fun clickFragments(view: View?) {
        redirectActivity(this, Name::class.java)
    }


    override fun onPause() {
        super.onPause()
        //Close drawer
        drawerLayout?.let { closeDrawer(it) }
    }
}