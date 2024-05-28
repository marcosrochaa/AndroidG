package com.globo.aprendizado

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.globo.aprendizado.adapter.CarroAdapter
import com.globo.aprendizado.adapter.CarroCallback
import com.globo.aprendizado.model.Carro
import com.globo.aprendizado.model.Retrofit.carService
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lista = mutableListOf<Carro>()

        val listView: ListView = findViewById(R.id.lvCarro)
        val adapter = CarroAdapter(this, lista, object : CarroCallback {
            override fun onCarroClick(carro: Carro) {
                TODO("Not yet implemented")
            }

        })
        listView.adapter = adapter

        val call = carService.getCarros()

        call.enqueue(object : retrofit2.Callback<List<Carro>> {
            override fun onResponse(p0: Call<List<Carro>>, p1: Response<List<Carro>>) {
                if (p1.code() == 200) {
                    lista.addAll(p1.body().orEmpty())
                    adapter.notifyDataSetChanged()
                } else {
                    println("Erro!")
                }
            }

            override fun onFailure(p0: Call<List<Carro>>, p1: Throwable) {
                println("Erro!")
            }

        })

    }
}