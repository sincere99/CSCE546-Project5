package com.example.csce546_project5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2


class Name : AppCompatActivity() {
    private var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        //Initialize views
        drawerLayout = findViewById(R.id.drawer_layout)
        val submitButton: Button = findViewById(R.id.submitName)
        val enterName: EditText = findViewById(R.id.enterName)
        val userName: TextView = findViewById(R.id.userName)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)

        //Set up viewpager
        val fragments: ArrayList<Fragment> = arrayListOf(
            FirstFragment(),
            SecondFragment()
        )

        //View page adapter for fragments
        val adapter = ViewPagerAdapter(fragments, this)
        viewPager.adapter = adapter

        //Submits the user input when button is clicked
        submitButton.setOnClickListener {
            // Place input from edit text into a string and displays output
            val name: String = enterName.text.toString()
            userName.visibility = View.VISIBLE
            userName.text = "$name"
        }
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
        redirectActivity(this, MainActivity::class.java)
    }

    //Redirect to Fragments activity
    fun clickFragments(view: View?) {
        recreate()
    }

    override fun onPause() {
        super.onPause()
        //Close drawer
        drawerLayout?.let { closeDrawer(it) }
    }
}