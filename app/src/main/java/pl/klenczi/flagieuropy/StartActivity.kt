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
        var czarny = 0

        val sw = findViewById<Switch>(R.id.swIle)
        sw.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switch = 1
            } else {
                switch = 0
            }
        }

        val filter = findViewById<Button>(R.id.btnFilter)

        val cbCzarny = findViewById<CheckBox>(R.id.cbCzarny)

        cbCzarny.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                czarny = 1

            } else {
                if(switch == 0){czarny = 2}
            }
        }

        filter.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("czarny", czarny)

            startActivity(intent)
        }
    }
}