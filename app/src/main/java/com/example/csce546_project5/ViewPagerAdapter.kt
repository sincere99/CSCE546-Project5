package com.example.csce546_project5

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(val items: ArrayList<Fragment>, activity: AppCompatActivity) :
    FragmentStateAdapter(activity) {
    //Return item count
    override fun getItemCount(): Int {
        return items.size
    }

    //Creates a fragment based on item position index
    override fun createFragment(position: Int): Fragment {
        return items[position]
    }
}
