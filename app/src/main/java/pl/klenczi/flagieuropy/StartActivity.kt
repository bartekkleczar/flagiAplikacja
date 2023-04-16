package pl.klenczi.flagieuropy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Switch

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val filter = findViewById<Button>(R.id.btnFilter)
        filter.visibility = View.INVISIBLE
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
            if(key == "aab" || key == "aba" || key == "baa") {filter.visibility = View.VISIBLE}
        }

        var czerwony = 0
        var bialy = 0
        var niebieski = 0
        var czarny = 0

        val cbCzerwony = findViewById<CheckBox>(R.id.cbCzerwony)
        cbCzerwony.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                czerwony = 1
                key += "a"
                if(key == "aab" || key == "aba" || key == "baa" || (key.length > 3 && "b" in key)) {filter.visibility = View.VISIBLE}
            } else {
                czerwony = 0
            }
        }

        val cbbialy = findViewById<CheckBox>(R.id.cbBialy)
        cbbialy.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                bialy = 1
                key += "a"
                if(key == "aab" || key == "aba" || key == "baa" || (key.length > 3 && "b" in key)) {filter.visibility = View.VISIBLE}
            } else {
                bialy = 0
            }
        }

        val cbniebieski = findViewById<CheckBox>(R.id.cbNiebieski)
        cbniebieski.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                niebieski = 1
                key += "a"
                if(key == "aab" || key == "aba" || key == "baa" || (key.length > 3 && "b" in key)) {filter.visibility = View.VISIBLE}
            } else {
                niebieski = 0
            }
        }
        
        val cbCzarny = findViewById<CheckBox>(R.id.cbCzarny)
        cbCzarny.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                czarny = 1
                key += "a"
                if(key == "aab" || key == "aba" || key == "baa" || (key.length > 3 && "b" in key)) {filter.visibility = View.VISIBLE}
            } else {
                czarny = 0
            }
        }

        filter.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("czerwony", czerwony)
            intent.putExtra("bialy", bialy)
            intent.putExtra("niebieski", niebieski)
            intent.putExtra("czarny", czarny)
            intent.putExtra("pozycja", pozycja)

            startActivity(intent)
        }
    }
}