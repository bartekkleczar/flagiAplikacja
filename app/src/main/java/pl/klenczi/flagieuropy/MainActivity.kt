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
        val znaczek = intent.getBooleanExtra("znaczek", false)

        val info = findViewById<TextView>(R.id.tvInfo)
        var text = ""
        if(czerwony == 1 || czerwony == 2){text += "Czerwony "}
        if(bialy == 1 || bialy == 2){text += "Biały "}
        if(niebieski == 1 || niebieski == 2){text += "Niebieski "}
        if(czarny == 1 || czarny == 2){text += "Czarny "}
        text += "| $pozycja"
        info.text = text

        filterKolory(panstwa, panstwaPoKolorach, cze = czerwony, bi = bialy, ni = niebieski, cza = czarny)
        if(pozycja != null){ filterUlozenie(panstwaPoKolorach, panstwaPoUlozeniu, u = pozycja) }
        filterZnaczek(panstwaPoUlozeniu, panstwaPoZnaczku, z = znaczek)

        fun ostatiaLista(p: MutableList<Panstwo>, pk: MutableList<Panstwo>, pu: MutableList<Panstwo>, pz: MutableList<Panstwo>): MutableList<Panstwo> {
            if(!pz.isEmpty()){return pz}
            else if(!pu.isEmpty()){return pu}
            else if(!pk.isEmpty()){return pk}
            else if(!p.isEmpty()){return p}
            else{return p}
        }

        rv.adapter = RvAdapter(panstwaPoZnaczku)
    }
}