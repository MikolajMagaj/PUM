package com.example.lista1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val quiz = listOf(
        Quiz(
            0,
            "Istnieją 3 Zasady dynamiki Newtona.",
            "true",
            "https://pl.wikipedia.org/wiki/Zasady_dynamiki_Newtona"
        ),
        Quiz(
            1,
            "Jest 8 jednostek układu SI.",
            "false",
            "https://pl.wikibooks.org/wiki/Fizyka_dla_liceum/Jednostki_uk%C5%82adu_SI"
        ),
        Quiz(
            2,
            "Kinetyka zajmuje się zachowaniem ciał fizycznych w ruchu.",
            "true",
            "https://pl.wikipedia.org/wiki/Kinetyka"
        ),
        Quiz(
            3,
            "Pochodna przyspieszenia po czasie to prędkość.",
            "false",
            "https://pl.wikipedia.org/wiki/Przyspieszenie"
        ),
        Quiz(
            4,
            "Najmniejsze cząsteczki elementarne to elektrony.",
            "true",
            "http://dydaktyka.fizyka.umk.pl/nowa_strona/?q=node/174"
        ),
        Quiz(
            5,
            "Dżul nie należy do jednostek układu SI.",
            "true",
            "https://pl.wikibooks.org/wiki/Fizyka_dla_liceum/Jednostki_uk%C5%82adu_SI"
        ),
        Quiz(
            6,
            "Prawo Ohma to prawo odnoszące się do termodynamiki.",
            "false",
            "https://pl.wikipedia.org/wiki/Prawo_Ohma"
        ),
        Quiz(
            7,
            "Prędkość (v) to iloraz przebytej drogi (s) w danym czasie (t).",
            "true",
            "https://pl.wikipedia.org/wiki/Pr%C4%99dko%C5%9B%C4%87"
        ),
        Quiz(
            8,
            "Laser to urządzenie emitujące promieniowanie elektromagnetyczne.",
            "true",
            "https://pl.wikipedia.org/wiki/Laser"
        ),
        Quiz(
            9,
            "Prędkość światła to 340 m/s.",
            "false",
            "https://pl.wikipedia.org/wiki/Pr%C4%99dko%C5%9B%C4%87_%C5%9Bwiat%C5%82a"
        )
    )

    private var question_number = 0
    private var points = 0
    private var cheated_question = 0
    private var correct = 0

    private val Fbutton: Button by lazy { findViewById(R.id.button) }
    private val Tbutton: Button by lazy { findViewById(R.id.button2) }
    private val questionTxt: TextView by lazy { findViewById(R.id.textView) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null){
            question_number = savedInstanceState.getInt("question_state")
            points = savedInstanceState.getInt("points_state")
            cheated_question = savedInstanceState.getInt("cheated_question_state")
            correct = savedInstanceState.getInt("correct_state")
        }
        showQuestion()

        Fbutton.setOnClickListener{
            if(quiz[question_number].answer == "false"){
                points += 10
                correct++
            }
            question_number++
            checkResult()
        }
        Tbutton.setOnClickListener{
            if(quiz[question_number].answer == "true"){
                points += 10
                correct++
            }
            question_number++
            checkResult()
        }

    }

    fun goCheat(view: View){
        val answer = quiz[question_number].answer
        val url = quiz[question_number].link
        cheated_question++
        points -= 15
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra(EXTRA_MESSAGE, answer)
            putExtra(EXTRA_URL, url)
        }
        startActivity(intent)
    }
    private fun checkResult(){
        if(question_number < quiz.size)
            showQuestion()
        else
            questionTxt.text = "Quiz zrobiony! Zdobyto $points punktów. Twoje poprawne odpowiedzi to $correct, a oszukano $cheated_question razy."
    }
    private fun showQuestion() {
        val question = quiz[question_number]
        questionTxt.text = question.question
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("question_state", question_number)
        outState.putInt("points_state", points)
        outState.putInt("cheated_question_state", cheated_question)
        outState.putInt("correct_state", correct)
    }
}