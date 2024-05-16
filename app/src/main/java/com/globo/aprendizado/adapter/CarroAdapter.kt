package com.globo.aprendizado.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.globo.aprendizado.R
import com.globo.aprendizado.model.Carro

class CarroAdapter(
    context: Context,
    private val lista: List<Carro>,
    private val callback: CarroCallback
) : ArrayAdapter<Carro>(context, 0, lista) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        itemView = LayoutInflater.from(context).inflate(R.layout.carro_item, parent, false)

        val carro = lista.get(position)

        val imageView: ImageView = itemView.findViewById(R.id.ivCarro)
        val tvNome: TextView = itemView.findViewById(R.id.tvNome)
        val tvAno: TextView = itemView.findViewById(R.id.ano)
        val tvCor: TextView = itemView.findViewById(R.id.cor)
        val tvPreco: TextView = itemView.findViewById(R.id.preco)

        imageView.setImageResource(carro.image)
        tvNome.text = carro.nome
        tvAno.text = carro.year
        tvCor.text = carro.color
        tvPreco.text = carro.preco


        itemView.setOnClickListener{
            callback.onCarroClick(carro)
        }
        return itemView


        val botao = null
        val bntDelete = botao
    }


}

public interface CarroCallback {
    fun onCarroClick(carro: Carro)
}