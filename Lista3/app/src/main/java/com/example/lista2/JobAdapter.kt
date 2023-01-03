package com.example.lista2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class JobAdapter(
    private val jobList: MutableList<Job>
    ) : RecyclerView.Adapter<JobAdapter.JobListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JobListViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_layout,
            parent,
            false
        )
        return JobListViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: JobListViewHolder, position: Int) {
        val currentItem = jobList[position]
        holder.title.text = currentItem.title
    }

    override fun getItemCount(): Int = jobList.size

    inner class JobListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.title)


        init{
            itemView.setOnClickListener{
                val dataBundle = Bundle()
                dataBundle.putString("TITLE", jobList[adapterPosition].title)
                dataBundle.putString("DETAILS", jobList[adapterPosition].details)
                dataBundle.putInt("ID", jobList[adapterPosition].id)
                Navigation.findNavController(itemView).navigate(R.id.action_homeFragment_to_detailsFragment, dataBundle)
            }
        }
    }

}