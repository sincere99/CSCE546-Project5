package com.example.csce546_project5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private val bios: List<Character>,
    private val listener: OnItemClickListener
    ) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bios.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bio: Character = bios[position]

        holder.tvName.text = bio.name
        holder.tvAlias.text = bio.alias
        holder.ivImage.setImageResource(bio.image)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val tvName: TextView = itemView.findViewById(R.id.tv_Name)
        val tvAlias: TextView = itemView.findViewById(R.id.tv_Alias)
        val ivImage: ImageView = itemView.findViewById(R.id.iv_Image)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            listener.onItemClick(position)
        }
    }
    interface  OnItemClickListener {
        fun onItemClick(position: Int)
    }
}