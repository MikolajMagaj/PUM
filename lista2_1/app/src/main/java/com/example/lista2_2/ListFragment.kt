package com.example.lista2_2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    private lateinit var adapter: CrimeAdapter
    private lateinit var recycleView: RecyclerView
    private lateinit var crimeList: List<Crime>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInit()

        val layoutManager = LinearLayoutManager(context)
        recycleView = view.findViewById(R.id.recyclerView)
        recycleView.layoutManager = layoutManager
        recycleView.setHasFixedSize(true)
        adapter = CrimeAdapter(crimeList)
        recycleView.adapter = adapter
    }

    private fun dataInit(){
        crimeList = ListOfCrimes()
    }

}