package com.globo.aprendizado

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.globo.aprendizado.adapter.CarroAdapter
import com.globo.aprendizado.adapter.CarroCallback
import com.globo.aprendizado.model.Carro
import com.globo.aprendizado.model.Pessoa

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //collection
        val lista: List<Pessoa> = listOf(
            Pessoa("Alan turing", R.drawable.alan),
            Pessoa("Linus Torvalds", R.drawable.linus),
            Pessoa("Steve Jobs", R.drawable.jobs)
        )

        val listaCarro: List<Carro> = listOf(
            Carro("Uno", R.drawable.fiatuno, "2010", "preto", "20.000"),
            Carro("Celta", R.drawable.gmcelta, "2008", "Prata", "15.000"),
            Carro("Fusca", R.drawable.vwfusca, "2000", "Brano", "8.000"),
        )

        val callback = object : CarroCallback {
            override fun onCarroClick(carro: Carro) {
                println(carro)
                Toast.makeText(this@MainActivity, carro.toString(), Toast.LENGTH_SHORT).show()
            }

        }

        val listView: ListView = findViewById(R.id.lvPessoa)
        listView.adapter = CarroAdapter(this, listaCarro, callback)

        val car : carr

    }
}