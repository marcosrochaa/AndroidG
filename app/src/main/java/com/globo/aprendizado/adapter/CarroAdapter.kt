package com.globo.aprendizado.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.globo.aprendizado.R
import com.globo.aprendizado.model.Carro
import com.squareup.picasso.Picasso

class CarroAdapter(
    context: Context,
    private val lista: MutableList<Carro>,
    private val callback: CarroCallback
) : ArrayAdapter<Carro>(context, 0, lista) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        itemView = LayoutInflater.from(context).inflate(R.layout.carro_item, parent, false)

        val carro = lista.get(position)

        val imageView: ImageView = itemView.findViewById(R.id.ivCarro)
        val ivCircle : ImageView = itemView.findViewById(R.id.ivCircle)
        val tvNome: TextView = itemView.findViewById(R.id.tvNome)
        val tvAno: TextView = itemView.findViewById(R.id.ano)
        val tvCor: TextView = itemView.findViewById(R.id.cor)
        val tvPreco: TextView = itemView.findViewById(R.id.preco)
        val botao : Button = itemView.findViewById(R.id.btnDelete)
        val marca : ImageView = itemView.findViewById(R.id.ivMarca)



       // imageView.setImageResource(carro.image)
        tvNome.text = carro.nome
        tvAno.text = carro.year
        tvCor.text = carro.color
        tvPreco.text = carro.preco.toString()

        when(carro.color){
            "Vermelho" -> ivCircle.setColorFilter(Color.RED)
            "Prata" -> ivCircle.setColorFilter(Color.GRAY)
            "Branco" -> ivCircle.setColorFilter(Color.BLUE)
        }

        //alterar depois
       // marca.setImageResource(carro.marca)

        if (carro.preco <= 10000.0){
            tvPreco.setTextColor(Color.GREEN)
        }


        itemView.setOnClickListener{
            callback.onCarroClick(carro)
        }



        botao.setOnClickListener {
        lista.remove(carro)
           notifyDataSetChanged()
        }
        Picasso.get().load(carro.image).into(imageView)


        return itemView

    }


}

public interface CarroCallback {
    fun onCarroClick(carro: Carro)
}