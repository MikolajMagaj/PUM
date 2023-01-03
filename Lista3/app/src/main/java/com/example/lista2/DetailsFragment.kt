package com.example.lista2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class DetailsFragment : Fragment() {

    private lateinit var db: SQLiteDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        db = context!!.openOrCreateDatabase("Jobs", Context.MODE_PRIVATE, null)
        db.execSQL(BasicCommand.SQL_CREATE_TABLE)

        val view = inflater.inflate(R.layout.fragment_details, container, false)
        view.findViewById<TextView>(R.id.DF_list).text = "Lista: ${ arguments?.getInt("ID") }"
        view.findViewById<TextView>(R.id.DF_title).text = "Tytuł: ${ arguments?.getString("TITLE") }"
        view.findViewById<TextView>(R.id.DF_details).text = "Szczegóły: ${ arguments?.getString("DETAILS") }"


        val button = view.findViewById<Button>(R.id.df_button_back)
        val editButton = view.findViewById<Button>(R.id.df_button_edit)

        button.setOnClickListener{
            findNavController().navigate(R.id.action_detailsFragment_to_homeFragment)
        }

        editButton.setOnClickListener{
            findNavController().navigate(R.id.action_detailsFragment_to_editFragment, arguments)
        }

        return view
    }

}