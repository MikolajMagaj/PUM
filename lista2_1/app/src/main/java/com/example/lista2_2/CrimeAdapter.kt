package com.example.lista2_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class CrimeAdapter(
    private val crimeList: List<Crime>
) : RecyclerView.Adapter<CrimeAdapter.CrimeViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeViewHolder {
        return CrimeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_layout,
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: CrimeViewHolder, position: Int) {
        val crime = crimeList[position]
        holder.title.text = crime.title
        holder.date.text = crime.date
        if(crime.isSolved) holder.image.visibility = View.VISIBLE
        else holder.image.visibility = View.INVISIBLE
    }

    override fun getItemCount(): Int = crimeList.size

    inner class CrimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val date: TextView = itemView.findViewById(R.id.date)
        val image : ImageView = itemView.findViewById(R.id.imageView)

        init{
            itemView.setOnClickListener{
                val dataBundle = Bundle()
                dataBundle.putString("TITLE", crimeList[adapterPosition].title)
                dataBundle.putString("DATE", crimeList[adapterPosition].date)
                dataBundle.putString("NAME", crimeList[adapterPosition].name)
                dataBundle.putString("CONTENT", crimeList[adapterPosition].content)
                dataBundle.putInt("ID_STUDENT", crimeList[adapterPosition].id_student)
                dataBundle.putBoolean("IS_SOLVED", crimeList[adapterPosition].isSolved)

                Navigation.findNavController(itemView).navigate(R.id.action_listFragment_to_detailFragment, dataBundle)

            }
        }
    }

}