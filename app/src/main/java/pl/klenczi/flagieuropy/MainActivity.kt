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

        var albania = Panstwo("albania", u = "inne", z = true, cze = 1, bi = 0, ni = 0, cza = 1, image = R.drawable.albania)
        var andora = Panstwo("andora", u = "pionowe", z = true, cze = 1, bi = 0, ni = 1, cza = 0, image = R.drawable.andora)
        var armenia = Panstwo("armenia", u = "pionowe", z = false, cze = 1, bi = 0, ni = 1, cza = 0, image = R.drawable.armenia)
        var austria = Panstwo("austria", u = "poziome", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.austria)
        var azerbejdzan = Panstwo("azerbejdzan", u = "poziome", z = true, cze = 1, bi = 1, ni = 1, cza = 0, image = R.drawable.azerbejdzan)
        var anglia = Panstwo("anglia", u = "krzyz", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.anglia)
        var niemcy = Panstwo("niemcy", u = "poziome", z = false, cze = 1, bi = 0, ni = 0, cza = 1, image = R.drawable.niemcy)
        var polska = Panstwo("polska", u = "poziome", z = false, cze = 1, bi = 1, ni = 0, cza = 0, image = R.drawable.polska)

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
        //filterUlozenie(panstwaPoKolorach, panstwaPoUlozeniu, u = "krzyz")

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