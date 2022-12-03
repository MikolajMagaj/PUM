package com.example.lista2_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        view.findViewById<TextView>(R.id.DF_title).text = "Tytuł: ${ arguments?.getString("TITLE") }"
        view.findViewById<TextView>(R.id.DF_date).text = "Data: ${ arguments?.getString("DATE") }"
        view.findViewById<TextView>(R.id.DF_name).text = "Imię i nazwisko: ${ arguments?.getString("NAME") }"
        view.findViewById<TextView>(R.id.DF_content).text = "Treść przestępstwa: ${ arguments?.getString("CONTENT") }"
        view.findViewById<TextView>(R.id.DF_id_student).text = "Indeks: ${ arguments?.getInt("ID_STUDENT") }"


        val isSolved = arguments?.getBoolean("IS_SOLVED")
        if(isSolved != null){
            if(isSolved) view.findViewById<TextView>(R.id.DF_isSolved).text = "Status: rozwiązane"
            else view.findViewById<TextView>(R.id.DF_isSolved).text = "Status: nierozwiązane"
        }


        val button = view.findViewById<Button>(R.id.df_button)
        button.setOnClickListener{
            findNavController().navigate(R.id.action_detailFragment_to_listFragment)
        }

        return view
    }

}