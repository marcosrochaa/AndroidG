package com.globo.aprendizado.api

import com.globo.aprendizado.model.Carro
import com.globo.aprendizado.model.Pessoa
import retrofit2.Call
import retrofit2.http.GET

interface CarsService {
    @GET("carros")
    fun getCarros(): Call<List<Carro>>

    @GET("pessoas")
    fun getPessoas(): Call<List<Pessoa>>
}