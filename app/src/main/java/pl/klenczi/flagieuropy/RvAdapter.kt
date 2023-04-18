package pl.klenczi.hindustlumaczyrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import pl.klenczi.flagieuropy.Panstwo
import pl.klenczi.flagieuropy.R

class RvAdapter(private val kraje: List<Panstwo>): RecyclerView.Adapter<MyVHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVHolder {
        // tego nie tykasz w zasadzie bo po co, wazne ze dziala
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyVHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyVHolder, position: Int) {
        // tu dawaj to co chcesz wyswietlic
        val kraj = kraje[position]

        holder.bind(kraj, position+1)
    }

    override fun getItemCount(): Int {
        // tu ustalasz ilosc elementow
        return kraje.size
    }

}

class MyVHolder(val view: View):RecyclerView.ViewHolder(view){
    fun bind(panstwo: Panstwo, position: Int) {
        val kraj = view.findViewById<TextView>(R.id.tvKraj)
        kraj.text = panstwo.n

        val flaga = view.findViewById<ImageView>(R.id.ivFlaga)
        flaga.setImageResource(panstwo.image)

        val pozycja = view.findViewById<TextView>(R.id.tvPozycja)
        pozycja.text = position.toString()
    }
}