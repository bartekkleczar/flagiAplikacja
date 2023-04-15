package pl.klenczi.flagieuropy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val filter = findViewById<Button>(R.id.btnFilter)

        val cbCzarny = findViewById<CheckBox>(R.id.cbCzarny)
        var czarny = 0
        cbCzarny.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                czarny = 1

            } else {
                czarny = 0
            }
        }

        filter.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("czarny", czarny)

            startActivity(intent)
        }
    }
}