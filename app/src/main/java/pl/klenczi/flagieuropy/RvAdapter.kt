package pl.klenczi.hindustlumaczyrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
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

        holder.bind(kraj)
    }

    override fun getItemCount(): Int {
        // tu ustalasz ilosc elementow
        return kraje.size
    }

}

class MyVHolder(val view: View):RecyclerView.ViewHolder(view){
    fun bind(panstwo: Panstwo) {
        val kraj = view.findViewById<TextView>(R.id.tvKraj)
        kraj.text = panstwo.n
    }
}