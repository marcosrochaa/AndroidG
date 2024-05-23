package com.globo.aprendizado

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.globo.aprendizado.adapter.CarroAdapter
import com.globo.aprendizado.adapter.CarroCallback
import com.globo.aprendizado.model.Carro
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
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
        WebAsyncTask(lista, adapter).execute()

    }


    class WebAsyncTask(
        private val listaCarros: MutableList<Carro>,
        private val adapter: CarroAdapter
    ) : AsyncTask<String, Void, Boolean>() {
        override fun doInBackground(vararg params: String?): Boolean {
            return try {


                val url = URL("https://9jg03.wiremockapi.cloud/carros")

                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.connectTimeout = 10000
                connection.readTimeout = 10000

                val responseCode = connection.responseCode

                println(responseCode)
                if (responseCode == 200) {
                    //sucesso
                    val inputStream = connection.inputStream
                    val response = inputStream.bufferedReader().use { it.readText() }

                    val jsonArray = JSONArray(response)

                    for (i in 0 until jsonArray.length()) {
                        val json = jsonArray.getJSONObject(i)

                        val carro = Carro(
                            json.getString("modelo"),
                            json.getString("imagem"),
                            json.getString("ano"),
                            json.getString("cor"),
                            json.getDouble("preco"),
                            json.getString("marca"),
                        )

                        listaCarros.add(carro)
                    }

                    println(listaCarros)

                }

                return true
            } catch (e : Exception){
                print(e.toString())
                return false
            }
        }

        override fun onPostExecute(result: Boolean?) {
            adapter.notifyDataSetChanged()
        }
    }
}