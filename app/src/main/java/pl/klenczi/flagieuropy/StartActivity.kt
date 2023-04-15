package pl.klenczi.flagieuropy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Switch

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        
        var switch = 0
        var czerwony = 0
        var bialy = 0
        var niebieski = 0
        var czarny = 0

        val sw = findViewById<Switch>(R.id.swIle)
        sw.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switch = 1
            } else {
                switch = 0
            }
        }

        val cbCzerwony = findViewById<CheckBox>(R.id.cbCzerwony)
        cbCzerwony.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                czerwony = 1

            } else {
                if(switch == 0){czerwony = 2}
            }
        }

        val cbbialy = findViewById<CheckBox>(R.id.cbBialy)
        cbbialy.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                bialy = 1

            } else {
                if(switch == 0){bialy = 2}
            }
        }

        val cbniebieski = findViewById<CheckBox>(R.id.cbNiebieski)
        cbniebieski.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                niebieski = 1

            } else {
                if(switch == 0){niebieski = 2}
            }
        }
        
        val cbCzarny = findViewById<CheckBox>(R.id.cbCzarny)
        cbCzarny.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                czarny = 1

            } else {
                if(switch == 0){czarny = 2}
            }
        }

        val filter = findViewById<Button>(R.id.btnFilter)
        filter.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("czerwony", czerwony)
            intent.putExtra("bialy", bialy)
            intent.putExtra("niebieski", niebieski)
            intent.putExtra("czarny", czarny)

            startActivity(intent)
        }
    }
}