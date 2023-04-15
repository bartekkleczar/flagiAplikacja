package pl.klenczi.flagieuropy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.klenczi.hindustlumaczyrecyclerview.RvAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val albania = Panstwo("Albania", u = "inne", z = true, cze = 1, bi = 0, ni = 0, cza = 1, image = R.drawable.albania)
        val andora = Panstwo("Andora", u = "pionowe", z = true, cze = 1, bi = 0, ni = 1, cza = 0, image = R.drawable.andora)
        val armenia = Panstwo("Armenia", u = "pionowe", z = false, cze = 1, bi = 0, ni = 1, cza = 0, image = R.drawable.armenia)
        val austria = Panstwo("Austria", u = "poziome", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.austria)
        val azerbejdzan = Panstwo("Azerbejdzan", u = "poziome", z = true, cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.azerbejdzan)
        val anglia = Panstwo("Anglia", u = "krzyz", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.anglia)
        val niemcy = Panstwo("Niemcy", u = "poziome", z = false, cze = 1, bi = 0, ni = 0, cza = 1, image = R.drawable.niemcy)
        val polska = Panstwo("Polska", u = "poziome", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.polska)

        val panstwa = mutableListOf<Panstwo>(
            albania, andora, armenia, austria, azerbejdzan, anglia, niemcy, polska
        )

        val panstwaPoKolorach = mutableListOf<Panstwo>()
        val panstwaPoUlozeniu = mutableListOf<Panstwo>()
        val panstwaPoZnaczku = mutableListOf<Panstwo>()

        val rv = findViewById<RecyclerView>(R.id.rvFlagi)
        val colorTla = ContextCompat.getColor(this, R.color.backgroundMa)
        rv.setBackgroundColor(colorTla)
        rv.layoutManager = LinearLayoutManager(this)

        filterKolory(panstwa, panstwaPoKolorach, cze = 1, bi = 1)
        filterUlozenie(panstwaPoKolorach, panstwaPoUlozeniu, u = "poziome")
        filterZnaczek(panstwaPoUlozeniu, panstwaPoZnaczku, z = true)

        fun ostatiaLista(p: MutableList<Panstwo>, pk: MutableList<Panstwo>, pu: MutableList<Panstwo>, pz: MutableList<Panstwo>): MutableList<Panstwo> {
            if(!pz.isEmpty()){return pz}
            if(!pu.isEmpty()){return pu}
            if(!pk.isEmpty()){return pk}
            if(!p.isEmpty()){return p}
            else{return p}
        }

        rv.adapter = RvAdapter(ostatiaLista(panstwa, panstwaPoKolorach, panstwaPoUlozeniu, panstwaPoZnaczku))
    }
}