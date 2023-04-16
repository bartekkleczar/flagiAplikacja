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

        val albania = Panstwo("Albania", u = "inne", z = true, cze = 1, bi = 0, ni = 0, cza = 1, image = R.drawable.albania)
        val andora = Panstwo("Andora", u = "pionowe", z = true, cze = 1, bi = 0, ni = 1, cza = 0, image = R.drawable.andora)
        val armenia = Panstwo("Armenia", u = "poziome", z = false, cze = 1, bi = 0, ni = 1, cza = 0, image = R.drawable.armenia)
        val austria = Panstwo("Austria", u = "poziome", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.austria)
        val azerbejdzan = Panstwo("Azerbejdzan", u = "poziome", z = true, cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.azerbejdzan)
        val anglia = Panstwo("Anglia", u = "krzyz", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.anglia)
        val bialorus = Panstwo("Bialorus", u = "poziome", z = true, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.bialorus)
        val bosnia = Panstwo("Bosnia", u = "inne", z = true, cze = 0, bi = 1, ni = 1, cza = 0, image = R.drawable.bosnia)
        val bulgaria = Panstwo("Bulgaria", u = "poziome", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.bulgaria)
        val chorwacja = Panstwo("Chorwacja", u = "poziome", z = true, cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.chorwacja)
        val niemcy = Panstwo("Niemcy", u = "poziome", z = false, cze = 1, bi = 0, ni = 0, cza = 1, image = R.drawable.niemcy)
        val polska = Panstwo("Polska", u = "poziome", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.polska)

        val panstwa = mutableListOf<Panstwo>(
            albania, andora, armenia, austria, azerbejdzan, anglia, bialorus,
            bosnia, bulgaria, chorwacja, niemcy, polska
        )

        val panstwaPoKolorach = mutableListOf<Panstwo>()
        val panstwaPoUlozeniu = mutableListOf<Panstwo>()
        val panstwaPoZnaczku = mutableListOf<Panstwo>()

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

        filterKolory(panstwa, panstwaPoKolorach, cze = czerwony, bi = bialy, ni = niebieski, cza = czarny)

        val info = findViewById<TextView>(R.id.tvInfo)
        var text = ""
        if(czerwony == 1){text += "Czerwony"}
        if(bialy == 1){text += " Biały"}
        if(niebieski == 1){text += " Niebieski"}
        if(czarny == 1){text += " Czarny"}
        text += "| $pozycja"
        info.text = text

        if(pozycja != null){ filterUlozenie(panstwaPoKolorach, panstwaPoUlozeniu, u = pozycja) }
        //filterZnaczek(panstwaPoUlozeniu, panstwaPoZnaczku, z = true)

        fun ostatiaLista(p: MutableList<Panstwo>, pk: MutableList<Panstwo>, pu: MutableList<Panstwo>, pz: MutableList<Panstwo>): MutableList<Panstwo> {
            if(!pz.isEmpty()){return pz}
            else if(!pu.isEmpty()){return pu}
            else if(!pk.isEmpty()){return pk}
            else if(!p.isEmpty()){return p}
            else{return p}
        }

        rv.adapter = RvAdapter(panstwaPoUlozeniu)
    }
}