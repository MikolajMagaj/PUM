package com.example.lista1

import android.content.Intent
import android.content.Intent.CATEGORY_BROWSABLE
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

const val EXTRA_MESSAGE = "com.example.lista1.MESSAGE"
const val EXTRA_URL = "com.example.lista1.URL"

class MainActivity2 : AppCompatActivity() {


    private val link: TextView by lazy { findViewById(R.id.link) }
    private val answer_txt: TextView by lazy { findViewById(R.id.answer) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val url = intent.getStringExtra(EXTRA_URL)
        val answer = intent.getStringExtra(EXTRA_MESSAGE)

        if(answer == "true") answer_txt.text = "Answer is true"
        else answer_txt.text = "Answer is false"

        link.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply{
                addCategory(CATEGORY_BROWSABLE)
            }
            if (intent.resolveActivity(packageManager) != null)
                startActivity(intent)
        }
    }
    fun goBack(view: View){
        finish()
    }
}