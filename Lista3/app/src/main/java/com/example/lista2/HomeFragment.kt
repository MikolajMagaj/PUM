package com.example.lista2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var adapter: JobAdapter
    private lateinit var recycleView: RecyclerView
    private lateinit var db: SQLiteDatabase
    private val jobList = mutableListOf<Job>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        db = context!!.openOrCreateDatabase("Jobs", Context.MODE_PRIVATE, null)
        db.execSQL(BasicCommand.SQL_CREATE_TABLE)

        val cursor = db.rawQuery("SELECT * FROM Jobs", null)
        while(cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val title = cursor.getString(1)
            val details = cursor.getString(2)
            val data = Job(id, title, details)
            jobList.add(data)
        }
        cursor.close()
        db.close()

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recycleView = view.findViewById(R.id.recyclerView)
        recycleView.layoutManager = layoutManager
        recycleView.setHasFixedSize(true)
        adapter = JobAdapter(jobList)
        recycleView.adapter = adapter

        val addButton = view.findViewById<Button>(R.id.button_add)
        addButton.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_editFragment)
        }
    }

}