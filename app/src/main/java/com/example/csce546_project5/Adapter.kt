package com.example.csce546_project5

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "CharacterAdapter"

class ContactsAdapter(private val context: Context, private val bios: List<Character>) :
    RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card, parent, false))
    }

    override fun getItemCount(): Int {
        return bios.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder: $position")
        val bio: Character = bios[position]
        holder.bind(bio)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName = itemView.findViewById<TextView>(R.id.tv_Name)
        private val tvDescription = itemView.findViewById<TextView>(R.id.tv_Description)
        private val ivImage: ImageView = itemView.findViewById(R.id.iv_Image)

        fun bind(bio: Character) {
            tvName.text = bio.name
            tvDescription.text = bio.description
            ivImage.setImageResource(bio.image)
        }
    }
}