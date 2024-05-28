package com.globo.aprendizado.model

import com.globo.aprendizado.api.CarsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Retrofit {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://9jg03.wiremockapi.cloud/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val carService: CarsService = retrofit.create(CarsService::class.java)

}