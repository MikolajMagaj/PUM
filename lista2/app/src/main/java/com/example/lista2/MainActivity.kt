package com.example.lista2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter(
    private val context: Context,
    private val crimeList: List<Crime>
) : RecyclerView.Adapter<WordListAdapter.WordListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordListAdapter.WordListViewHolder {
        return WordListViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.word_list_item,
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: WordListAdapter.WordListViewHolder, position: Int) {

        val word = crimeList[position]
        holder.title.text = word.title
        holder.date.text = word.date
        if(word.isSolved) holder.image.visibility = View.VISIBLE
        else holder.image.visibility = View.INVISIBLE
       // holder.image.invalidate()
        //narazie dol uselees
//        holder.itemView.setOnClickListener {
//            val element = holder.word.text
//            holder.word.text = "Crime #$element"
//            holder.word.setBackgroundColor(Color.CYAN)
//        }
    }

    override fun getItemCount() = crimeList.size

    class WordListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val date: TextView = itemView.findViewById(R.id.date)
        val image : ImageView = itemView.findViewById(R.id.imageView)
    }

}

class MainActivity : AppCompatActivity() {

    private val crimeList = listOf(
        Crime(
            0,
            "Brak zwrotu książki",
            "Wtorek, 29.05.2022 14:00",
            "Ryszard Brubanek",
            "Student nie oddał wypożyczonej książki do biblioteki w umówionym terminie",
            359120,
            true
        ),
        Crime(
            1,
            "Blokada dostępu",
            "Środa, 20.02.2022, 15:34",
            "Kazimierz Poprawa",
            "Student przekroczył liczbę wpisania hasła do wspólnego konta CISCO oraz zablokował dostęp do konta całej grupie",
            269420,
            true
        ),
        Crime(
            2,
            "Odłączenie kabla",
            "Poniedziałek, 21.11.2022, 16:34",
            "Kamil Bagaj",
            "Student nie dotrzymał kategorycznego zakazu odłączania kabli obowiązujego w sali, w celu podłączenia swojego laptopa potrzebnego do zajęć",
            322880,
            false
        ),
        Crime(
            3,
            "Brak obuwia zmiennego",
            "Środa, 19.10.2022, 10:21",
            "Anna Garcz",
            "Studentka wparowała do pracowni chemicznej w niezmiernie brudnych butach powodując zakłócenia badań",
            412127,
            false
        ),
        Crime(
            4,
            "Spóźnienie na pracownie elektroniczną",
            "Środa, 14.03.2022, 08:03",
            "Maria Wucior",
            "Studentka spóźniła się 3 minuty przez remonty linii tramwajowych, a po wyrzuceniu z zajęć zaczęła się kłócić, że postąpiono niesłusznie",
            321130,
            true
        ),
        Crime(
            5,
            "Picie wody",
            "Piątek, 21.06.2022 12:22",
            "Maja Fredka",
            "Studentka spożywała wodę w sali komputerowej, łamiąc zakaz",
            247726,
            true
        ),
        Crime(
            6,
            "Nieprzygotowanie do zajęć",
            "Piątek, 12.03.2022 10:18",
            "Mateusz Gotówka",
            "Student nie przygotował się z teorii wymaganej do uczestnictwa w laboratorium, został z nich wyproszony",
            416914,
            false
        ),
        Crime(
            7,
            "Nieuprzątnięcie stanowiska",
            "Czwartek, 13.04.2022 12:00",
            "Kinga Wawrzyniak",
            "Studentka nie posprzątała po sobie stanowiska w pracowni chemicznej",
            242067,
            true
        ),
        Crime(
            8,
            "Brak fartucha",
            "Czwartek, 06.04.2022 10:30",
            "Jakub Nowak",
            "Student nie posiadał obowiązkowego wyposażenia (fartucha), łamiąc regulamin pracowni chemicznej",
            243901,
            false
        ),
        Crime(
            9,
            "Agresja wobec kawomatu",
            "Poniedziałek, 29.05.2022 14:54",
            "Mateusz Zarych",
            "Student zepsuł kawomat, kopiąc go, ponieważ nie dostał swojej wymarzonej kawy",
            450981,
            false
        ),
        Crime(
            10,
            "Odłączenie kabla",
            "Środa, 23.11.2022, 12:12",
            "Karolina Fryś",
            "Studentka nie dotrzymała kategorycznego zakazu odłączania kabli obowiązujego w sali, w celu podłączenia swojego laptopa potrzebnego do zajęć",
            241190,
            true
        ),
        Crime(
            11,
            "Pobicie wykładowcy",
            "Piątek, 13.12.2022, 15:55",
            "Szymon Mierzwa",
            "Zbulwersowany oblaniem student zaatakował pięściami wykładowcę",
            510816,
            true
        ),
        Crime(
            12,
            "Ściąganie na egzaminie",
            "Czwartek, 10.02.2022, 10:14",
            "Marcelina Tarnowska",
            "Studentka została nakryta na ściąganiu z telefonu podczas egzaminu z matematyki",
            268730,
            true
        ),
        Crime(
            13,
            "Plagiat",
            "Poniedziałek, 31.03.2022, 17:35",
            "Marcel Ząbek",
            "Student dopuścił się skopiowania kodu koleżanki, popełniając wykroczenie zwane plagiatem",
            141255,
            false
        ),
        Crime(
            14,
            "Fałszywe zwolnienie lekarskie",
            "Wtorek, 16.10.2022, 10:00",
            "Liliana Weszło",
            "Studentka próbowała usprawiedliwić swoją nieobecność na kolokwium fałszywym zwolnieniem",
            278456,
            true
        ),
        Crime(
            15,
            "Zakłócanie zajęć",
            "Środa, 02.05.2022, 13:54",
            "Janusz Walczuk",
            "Student zakłócał prowadzenie wykładu bardzo głośnym chrapaniem",
            370821,
            true
        ),
        Crime(
            16,
            "Zepsucie windy",
            "Poniedziałek, 05.05.2022, 12:10",
            "Kamil Jarosz",
            "Student bawiąc się przyciskami windzie, spowodował jej zatrzymanie oraz zepsucie",
            164809,
            false
        ),
        Crime(
            17,
            "Palenie e-papieros w toalecie",
            "Wtorek, 06.04.2022, 8:48",
            "Sebastian Czekaj",
            "Student został przyłapany na paleniu e-papierosa w toalecie na 1. piętrze",
            211526,
            true
        ),
        Crime(
            18,
            "Kradzież kwiatka",
            "Środa, 12.06.2022, 13:45",
            "Bronisława Komorowska",
            "Studentka ukradła bardzo rzadki gatunek kwiatka z sali florystycznej",
            314320,
            false
        ),
        Crime(
            19,
            "Przyniesienie kota na zajęcia",
            "Czwartek, 11.04.2022, 10:10",
            "Jarosław Kadżyński",
            "Student wziął ze sobą kota do pracowni komputerowej",
            427802,
            true
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            adapter = WordListAdapter(this@MainActivity, crimeList as List<Crime>)
            layoutManager = LinearLayoutManager(this@MainActivity)

        }
    }
}