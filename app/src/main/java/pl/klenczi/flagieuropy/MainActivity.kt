package pl.klenczi.flagieuropy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.klenczi.hindustlumaczyrecyclerview.RvAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val powrot = findViewById<Button>(R.id.btnPowrot)

        powrot.setOnClickListener{
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

        val panstwaPoKolorach = mutableListOf<Panstwo>()
        val panstwaPoUlozeniu = mutableListOf<Panstwo>()
        val panstwaPoZnaczku = mutableListOf<Panstwo>()
        val panstwaPoNazwie = mutableListOf<Panstwo>()

        val rv = findViewById<RecyclerView>(R.id.rvFlagi)
        val colorTla = ContextCompat.getColor(this, R.color.backgroundMa)
        rv.setBackgroundColor(colorTla)
        rv.layoutManager = LinearLayoutManager(this)

        val intent = intent
        val czerwony = intent.getIntExtra("czerwony", 0)
        val bialy = intent.getIntExtra("bialy", 0)
        val niebieski = intent.getIntExtra("niebieski", 0)
        val czarny = intent.getIntExtra("czarny", 0)
        val pozycja = intent.getStringExtra("pozycja")
        val znaczek = intent.getIntExtra("znaczek", 0)
        val name = intent.getStringExtra("nazwa")

        val infoKolory = findViewById<TextView>(R.id.tvInfoKolory)
        var textColory = ""
        val kCzerwony = getString(R.string.Czerwony)
        val kBialy = getString(R.string.Biały)
        val kNiebieski = getString(R.string.Niebieski)
        val kCzarny = getString(R.string.Czarny)
        val kWszystkie = getString(R.string.WszytkieKolory)
        if(czerwony == 1 || czerwony == 2){textColory += "$kCzerwony "}
        if(bialy == 1 || bialy == 2){textColory += "$kBialy "}
        if(niebieski == 1 || niebieski == 2){textColory += "$kNiebieski "}
        if(czarny == 1 || czarny == 2){textColory += "$kCzarny "}
        if(textColory == "$kCzerwony $kBialy $kNiebieski $kCzarny "){textColory = "$kWszystkie, $name "}
        infoKolory.text = textColory

        val infoUlozenie = findViewById<TextView>(R.id.tvInfoUlozenie)
        val dowolne = getString(R.string.Dowolne)
        val nie = getString(R.string.nie)
        val tak = getString(R.string.tak)
        var znaczekInfo = dowolne
        when(znaczek){
            0 -> {znaczekInfo = nie}
            1 -> {znaczekInfo = tak}
            2 -> {znaczekInfo = dowolne}
        }
        val iUlozenie = getString(R.string.Ulozenie)
        val iZnaczek = getString(R.string.Znaczek)
        var iPozycja = ""
        when(pozycja){
            "pionowe" -> {iPozycja = getString(R.string.Pionowe)}
            "poziome" -> {iPozycja = getString(R.string.Poziome)}
            "krzyz" -> {iPozycja = getString(R.string.Krzyz)}
            "inne" -> {iPozycja = getString(R.string.Inne)}
            "dowolne" -> {iPozycja = getString(R.string.Dowolne)}
            else -> {iPozycja = getString(R.string.Dowolne)}
        }
        infoUlozenie.text = "$iUlozenie: $iPozycja, $iZnaczek: $znaczekInfo"


        filterKolory(panstwa, panstwaPoKolorach, cze = czerwony, bi = bialy, ni = niebieski, cza = czarny)
        if(pozycja != null){ filterUlozenie(panstwaPoKolorach, panstwaPoUlozeniu, u = pozycja) }
        filterZnaczek(panstwaPoUlozeniu, panstwaPoZnaczku, z = znaczek)
        filterNazwa(panstwaPoZnaczku, panstwaPoNazwie, name)


        val size = findViewById<TextView>(R.id.tvSize)
        val sBrakWynikow = getString(R.string.BrakWyników)
        val sIlosc = getString(R.string.Ilosc)
        when(panstwaPoNazwie.size){
            0 -> {
                size.text = sBrakWynikow
            }
            else ->{
                size.text = "$sIlosc: ${panstwaPoZnaczku.size}"
            }
        }

        rv.adapter = RvAdapter(panstwaPoNazwie)
    }
}