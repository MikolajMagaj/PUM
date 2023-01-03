package com.example.lista2

import android.app.Activity
import android.app.Activity.ACTIVITY_SERVICE
import android.app.Activity.RESULT_OK
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class EditFragment : Fragment() {

    private lateinit var db: SQLiteDatabase
    private lateinit var button: Button
    private lateinit var imageView: ImageView
companion object {
    private val SELECT_IMAGE_REQUEST_CODE = 100
}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit, container, false)
        db = context!!.openOrCreateDatabase("Jobs", Context.MODE_PRIVATE, null)
        db.execSQL(BasicCommand.SQL_CREATE_TABLE)

        val id = view.findViewById<TextView>(R.id.DF_list)
        val title = view.findViewById<EditText>(R.id.edit_title)
        val details = view.findViewById<EditText>(R.id.edit_details)
        val editButton = view.findViewById<Button>(R.id.button_confirm)
        val deleteButton = view.findViewById<Button>(R.id.button_delete)
        val button = view.findViewById<Button>(R.id.test1)
        val imageView = view.findViewById<ImageView>(R.id.imageView)

        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, SELECT_IMAGE_REQUEST_CODE)
    }

        if(arguments != null){
            id.text = "Lista: ${arguments?.getInt("ID")}"
            title.setText("${arguments?.getString("TITLE")}")
            details.setText("${arguments?.getString("DETAILS")}")
            deleteButton.isEnabled = true
        }
        else{
            id.text = "Nowa lista"
            title.setText("Wpisz tytuł")
            details.setText("Wprowadź szczegóły")
            deleteButton.isEnabled = false
        }



        editButton.setOnClickListener {
            val value = ContentValues()
            value.put("title", title.text.toString())
            value.put("details", details.text.toString())
            if(arguments != null){
                val selection = "id = ?"
                val selectionArgs = arrayOf(arguments?.getInt("ID").toString())
                val cursor = db.rawQuery("SELECT * FROM Jobs WHERE id = ?", selectionArgs)
                db.update("Jobs", value, selection, selectionArgs)
                cursor.close()
            }
            else
                db.insert("Jobs", null, value)

            db.close()
            findNavController().navigate(R.id.action_editFragment_to_homeFragment)
        }

        deleteButton.setOnClickListener {
            val selection = "id = ?"
            val selectionArgs = arrayOf(arguments?.getInt("ID").toString())

            db.delete("Jobs", selection, selectionArgs)
            db.close()
            findNavController().navigate(R.id.action_editFragment_to_homeFragment)
        }

        return view
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == SELECT_IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            imageView.setImageURI(data?.data)
        }
    }

}