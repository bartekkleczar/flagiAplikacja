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

        var Albania = Panstwo("Albania", u = "inne", z = true, cze = true, bi = false, ni = false, cza = true)
        var Andora = Panstwo("Andora", u = "pionowe", z = true, cze = true, bi = false, ni = true, cza = false)
        var Armenia = Panstwo("Armenia", u = "pionowe", z = false, cze = true, bi = false, ni = true, cza = false)
        var Austria = Panstwo("Austria", u = "poziome", z = false, cze = true, bi = true, ni = false, cza = false)
        var Azerbejdzan = Panstwo("Azerbejdzan", u = "poziome", z = true, cze = true, bi = true, ni = true, cza = false)
        var Anglia = Panstwo("Anglia", u = "krzyz", z = false, cze = true, bi = true, ni = false, cza = false)
        var Niemcy = Panstwo("Niemcy", u = "poziome", z = false, cze = true, bi = false, ni = false, cza = true)
        var Polska = Panstwo("Polska", u = "poziome", z = false, cze = true, bi = true, ni = false, cza = false)

        val panstwa = mutableListOf<Panstwo>(
            Albania, Andora, Armenia, Austria, Azerbejdzan, Anglia, Niemcy, Polska
        )

        val panstwaPoKolorach = mutableListOf<Panstwo>()
        val panstwaPoUlozeniu = mutableListOf<Panstwo>()
        val panstwaPoZnaczku = mutableListOf<Panstwo>()

        val rv = findViewById<RecyclerView>(R.id.rvFlagi)
        val colorTla = ContextCompat.getColor(this, R.color.backgroundMa)
        rv.setBackgroundColor(colorTla)
        rv.layoutManager = LinearLayoutManager(this)

        filterKolory(panstwa, panstwaPoKolorach, cze = true, bi = true)

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