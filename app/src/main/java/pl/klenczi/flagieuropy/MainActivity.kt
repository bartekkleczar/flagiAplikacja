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

        val resources = getResources()
        val albania =       Panstwo("Albania",          u = "inne",     z = 1,   cze = 1, bi = 0, ni = 0, cza = 1, image = R.drawable.albania)
        val andora =        Panstwo("Andora",           u = "pionowe",  z = 1,   cze = 1, bi = 0, ni = 1, cza = 0, image = R.drawable.andora)
        val armenia =       Panstwo("Armenia",          u = "poziome",  z = 0,  cze = 1, bi = 0, ni = 1, cza = 0, image = R.drawable.armenia)
        val austria =       Panstwo("Austria",          u = "poziome",  z = 0,  cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.austria)
        val azerbejdzan =   Panstwo("Azerbejdzan",      u = "poziome",  z = 1,   cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.azerbejdzan)
        val anglia =        Panstwo("Anglia",           u = "krzyz",    z = 0,  cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.anglia)
        val bialorus =      Panstwo("Bialorus",         u = "poziome",  z = 1,   cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.bialorus)
        val bosnia =        Panstwo("Bosnia",           u = "inne",     z = 1,   cze = 0, bi = 1, ni = 1, cza = 0, image = R.drawable.bosnia)
        val bulgaria =      Panstwo("Bulgaria",         u = "poziome",  z = 0,  cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.bulgaria)
        val chorwacja =     Panstwo("Chorwacja",        u = "poziome",  z = 1,   cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.chorwacja)
        val czarnogora =    Panstwo("Czarnogora",       u = "inne",     z = 1,   cze = 1, bi = 0, ni = 0, cza = 0, image = R.drawable.czarnogora)
        val czechy =        Panstwo("Czechy",           u = "poziome",  z = 0,  cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.czechy)
        val dania =         Panstwo("Dania",            u = "krzyz",    z = 0,  cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.dania)
        val estonia =       Panstwo("Estonia",          u = "poziome",  z = 0,  cze = 0, bi = 1, ni = 1, cza = 1, image = R.drawable.estonia)
        val finlandia =     Panstwo("Finlandia",        u = "krzyz",    z = 0,  cze = 0, bi = 1, ni = 1, cza = 0, image = R.drawable.finlandia)
        val francja =       Panstwo("Francja",          u = "pionowe",  z = 0,  cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.francja)
        val grecja =        Panstwo("Grecja",           u = "poziome",  z = 0,  cze = 0, bi = 1, ni = 1, cza = 0, image = R.drawable.grecja)
        val giblartar =     Panstwo("Giblartar",        u = "poziome",  z = 1,   cze = 1, bi = 1, ni = 0, cza = 2, image = R.drawable.giblartar)
        val hiszpania =     Panstwo("Hiszpania",        u = "poziome",  z = 1,   cze = 1, bi = 0, ni = 0, cza = 0, image = R.drawable.hiszpania)
        val holandia =      Panstwo("Holandia",         u = "poziome",  z = 0,  cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.holandia)
        val irlandia =      Panstwo("Irlandia",         u = "pionowe",  z = 0,  cze = 0, bi = 1, ni = 0, cza = 0, image = R.drawable.irlandia)
        val irlanidapln =   Panstwo("Irlanida Polnocna",u = "krzyz",    z = 1,   cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.irlanidapln)
        val islandia =      Panstwo("Islandia",         u = "krzyz",    z = 0,  cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.islandia)
        val kazachstan =    Panstwo("Kazachstan",       u = "inne",     z = 1,   cze = 0, bi = 0, ni = 1, cza = 0, image = R.drawable.kazachstan)
        val kosowo =        Panstwo("Kosowo",           u = "inne",     z = 1,   cze = 0, bi = 0, ni = 1, cza = 0, image = R.drawable.kosowo)
        val liechtenstein = Panstwo("Liechtenstein",    u = "poziome",  z = 1,   cze = 1, bi = 0, ni = 1, cza = 0, image = R.drawable.liechtenstein)
        val litwa =         Panstwo("Litwa",            u = "poziome",  z = 0,  cze = 1, bi = 0, ni = 0, cza = 0, image = R.drawable.litwa)
        val luksemburg =    Panstwo("Luksemburg",       u = "poziome",  z = 0,  cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.luksemburg)
        val lotwa =         Panstwo("Łotwa",            u = "poziome",  z = 0,  cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.lotwa)
        val macedonia =     Panstwo("Macedonia",        u = "inne",     z = 1,   cze = 1, bi = 0, ni = 0, cza = 0, image = R.drawable.macedonia)
        val malta =         Panstwo("Malta",            u = "pionowe",  z = 1,   cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.malta)
        val moldawia =      Panstwo("Moldawia",         u = "pionowe",  z = 1,   cze = 1, bi = 0, ni = 1, cza = 0, image = R.drawable.moldawia)
        val monako =        Panstwo("Monako",           u = "poziome",  z = 0,  cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.monako)
        val niemcy =        Panstwo("Niemcy",           u = "poziome",  z = 0,  cze = 1, bi = 0, ni = 0, cza = 1, image = R.drawable.niemcy)
        val norwegia =      Panstwo("Norwegia",         u = "krzyz",    z = 0,  cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.norwegia)
        val polska =        Panstwo(resources.getString(R.string.Polska),           u = "poziome",  z = 0,  cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.polska)
        val portugalia =    Panstwo("Portugalia",       u = "pionowe",  z = 1,   cze = 1, bi = 0, ni = 0, cza = 0, image = R.drawable.portugalia)
        val rosja =         Panstwo("Rosja",            u = "poziome",  z = 0,  cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.rosja)
        val rumunia =       Panstwo("Rumunia",          u = "pionowe",  z = 0,  cze = 1, bi = 0, ni = 1, cza = 0, image = R.drawable.rumunia)
        val sanmarino =     Panstwo("San Marino",       u = "poziome",  z = 1,   cze = 0, bi = 1, ni = 1, cza = 0, image = R.drawable.sanmarino)
        val serbia =        Panstwo("Seriba",           u = "poziome",  z = 1,   cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.serbia)
        val slowacja =      Panstwo("Slowacja",         u = "poziome",  z = 1,   cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.slowacja)
        val slowenia =      Panstwo("Slowenia",         u = "poziome",  z = 1,   cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.slowenia)
        val szkocja =       Panstwo("Szkocja",          u = "krzyz",    z = 0,  cze = 0, bi = 1, ni = 1, cza = 0, image = R.drawable.szkocja)
        val szwajcaria =    Panstwo("Szwajcaria",       u = "krzyz",    z = 0,  cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.szwajcaria)
        val szwecja =       Panstwo("Szwecja",          u = "krzyz",    z = 0,  cze = 0, bi = 0, ni = 1, cza = 0, image = R.drawable.szwecja)
        val turcja =        Panstwo("Turcja",           u = "inne",     z = 1,   cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.turcja)
        val ukraina =       Panstwo("Ukraina",          u = "poziome",  z = 0,  cze = 0, bi = 0, ni = 1, cza = 0, image = R.drawable.ukraina)
        val watykan =       Panstwo("Watykan",          u = "pionowe",  z = 1,   cze = 0, bi = 1, ni = 0, cza = 0, image = R.drawable.watykan)
        val walia =         Panstwo("Walia",            u = "poziome",  z = 1,   cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.walia)
        val wielkabrytania =Panstwo("Wielka Brytania",  u = "krzyz",    z = 0,  cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.wielkabrytania)
        val wegry =         Panstwo("Wegry",            u = "poziome",  z = 0,  cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.wegry)
        val wlochy =        Panstwo("Wlochy",           u = "pionowe",  z = 0,  cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.wlochy)
        val wyspyowcze =    Panstwo("Wyspy Owcze",      u = "krzyz",    z = 0,  cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.wyspyowcze)
        val wyspaman =      Panstwo("Wyspa Man",        u = "inne",     z = 1,   cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.wyspaman)


        val panstwa = mutableListOf<Panstwo>(
            albania, andora, armenia, austria, azerbejdzan, anglia, bialorus,
            bosnia, bulgaria, chorwacja, czarnogora, czechy, dania, estonia,
            finlandia, francja, grecja, giblartar, hiszpania, holandia, irlandia, irlanidapln, islandia,
            kazachstan, kosowo, liechtenstein, litwa, luksemburg, lotwa, macedonia, malta,
            moldawia, monako,niemcy, norwegia, polska, portugalia, rosja, rumunia,
            sanmarino, serbia, slowacja, slowenia, szkocja, szwajcaria, szwecja, turcja,
            ukraina, watykan, walia, wielkabrytania, wegry, wlochy, wyspyowcze, wyspaman
        )

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
        if(textColory == "$kCzerwony $kBialy $kNiebieski $kCzarny "){textColory = "$kWszystkie "}
        infoKolory.text = textColory

        val infoUlozenie = findViewById<TextView>(R.id.tvInfoUlozenie)
        val idowolne = getString(R.string.Dowolne)
        val inie = getString(R.string.nie)
        val itak = getString(R.string.tak)
        var znaczekInfo = idowolne
        when(znaczek){
            0 -> {znaczekInfo = inie}
            1 -> {znaczekInfo = itak}
            2 -> {znaczekInfo = idowolne}
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

        val tvInfoNazwa = findViewById<TextView>(R.id.tvInfoNazwa)
        tvInfoNazwa.text = "$name"


        filterKolory(panstwa, panstwaPoKolorach, cze = czerwony, bi = bialy, ni = niebieski, cza = czarny)
        if(pozycja != null){ filterUlozenie(panstwaPoKolorach, panstwaPoUlozeniu, u = pozycja) }
        filterZnaczek(panstwaPoUlozeniu, panstwaPoZnaczku, z = znaczek)
        if (name != null) {
            filterNazwa(panstwaPoZnaczku, panstwaPoNazwie, name.lowercase())
        }


        val size = findViewById<TextView>(R.id.tvSize)
        val sBrakWynikow = getString(R.string.BrakWyników)
        val sIlosc = getString(R.string.Ilosc)
        when(panstwaPoNazwie.size){
            0 -> {
                size.text = sBrakWynikow
            }
            else ->{
                size.text = "$sIlosc: ${panstwaPoNazwie.size}"
            }
        }

        rv.adapter = RvAdapter(panstwaPoNazwie)
    }
}