package com.globo.aprendizado.model

data class Carro(
    val nome: String,
    val image: Int,
    val year: String,
    val color: String,
    val preco: String
) {
    companion object {
        fun notifyDataSetChanged() {
            TODO("Not yet implemented")
        }
    }
}
