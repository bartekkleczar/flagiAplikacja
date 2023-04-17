package pl.klenczi.flagieuropy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.Toast

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        
        val switchZnaczek = findViewById<Switch>(R.id.switchZnaczek)
        switchZnaczek.isChecked = false
        var switchZn = false

        switchZnaczek.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switchZn = true
                Toast.makeText(this, "Znaczek: $switchZnaczek", Toast.LENGTH_SHORT).show()
            }
            if (!isChecked) {
                switchZn = false
                Toast.makeText(this, "Znaczek: $switchZnaczek", Toast.LENGTH_SHORT).show()
            }
        }
        if(!switchZnaczek.isChecked){switchZn = false}


        val switchKolory = findViewById<Switch>(R.id.switchKolory)
        switchZnaczek.isChecked = false
        var switch = 2

        switchKolory.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switch = 1
                Toast.makeText(this, "$switch", Toast.LENGTH_SHORT).show()
            }
            if (!isChecked) {
                switch = 2
                Toast.makeText(this, "$switch", Toast.LENGTH_SHORT).show()
            }
        }
        if(!switchZnaczek.isChecked){switchZn = false}


        val filter = findViewById<Button>(R.id.btnFilter)
        //filter.visibility = View.INVISIBLE
        var key = ""

        var pozycja = "dowolne"
        val rbGroup = findViewById<RadioGroup>(R.id.rbGroup)
        rbGroup.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.rbPionowe){pozycja = "pionowe"}
            else if(checkedId == R.id.rbPoziome){pozycja = "poziome"}
            else if(checkedId == R.id.rbKrzyz){pozycja = "krzyz"}
            else if(checkedId == R.id.rbInne){pozycja = "inne"}
            else if(checkedId == R.id.rbDowolne){pozycja = "dowolne"}
            key += "b"
            if(key == "ab" || key == "ba" || (key.length > 2 && "b" in key)) {filter.visibility = View.VISIBLE}
        }

        var czerwony = 0
        var bialy = 0
        var niebieski = 0
        var czarny = 0

        val cbCzerwony = findViewById<CheckBox>(R.id.cbCzerwony)
        cbCzerwony.isChecked = false
        cbCzerwony.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                czerwony = 1
                key += "a"
                if(key == "ab" || key == "ba" || (key.length > 2 && "b" in key)) {filter.visibility = View.VISIBLE}
            }
            if (!isChecked) {
                czerwony = 0
            }
        }
        if(!cbCzerwony.isChecked){czerwony = 0}

        val cbbialy = findViewById<CheckBox>(R.id.cbBialy)
        cbbialy.isChecked = false
        cbbialy.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                bialy = 1
                key += "a"
                if(key == "ab" || key == "ba" || (key.length > 2 && "b" in key)) {filter.visibility = View.VISIBLE}
            }
            if (!isChecked){
                bialy = 0
            }
        }
        if(!cbbialy.isChecked){bialy = 0}

        val cbniebieski = findViewById<CheckBox>(R.id.cbNiebieski)
        cbniebieski.isChecked = false
        cbniebieski.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                niebieski = 1
                key += "a"
                if(key == "ab" || key == "ba" || (key.length > 2 && "b" in key)) {filter.visibility = View.VISIBLE}
            }
            if (!isChecked) {
                niebieski = 0
            }
        }
        if(!cbniebieski.isChecked){niebieski = 0}
        
        val cbCzarny = findViewById<CheckBox>(R.id.cbCzarny)
        cbCzarny.isChecked = false
        cbCzarny.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                czarny = 1
                key += "a"
                if(key == "aab" || key == "aba" || key == "baa" || (key.length > 3 && "b" in key)) {filter.visibility = View.VISIBLE}
            }
            if (!isChecked) {
                czarny = 0
            }
        }
        if(!cbCzarny.isChecked){czarny = 0}

        filter.setOnClickListener{
            if(switch == 2 && czerwony == 0){czerwony = 2}
            if(switch == 1 && czerwony != 1){czerwony = 0}

            if(switch == 2 && bialy == 0){bialy = 2}
            if(switch == 1 && bialy != 1){bialy = 0}

            if(switch == 2 && niebieski == 0){niebieski = 2}
            if(switch == 1 && niebieski != 1){niebieski = 0}

            if(switch == 2 && czarny == 0){czarny = 2}
            if(switch == 1 && czarny != 1){czarny = 0}

            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("czerwony", czerwony)
            intent.putExtra("bialy", bialy)
            intent.putExtra("niebieski", niebieski)
            intent.putExtra("czarny", czarny)
            intent.putExtra("pozycja", pozycja)
            intent.putExtra("znaczek", switchZn)

            //switchKolory.isChecked = true
            switch = 1
            czerwony = 0
            bialy = 0
            niebieski = 0
            czarny = 0
            key = ""
            pozycja = "dowolne"
            switchZn = false

            startActivity(intent)
        }
    }
}