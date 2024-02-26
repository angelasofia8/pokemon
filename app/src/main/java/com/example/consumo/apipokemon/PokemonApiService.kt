package com.example.consumo.apipokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
   // @GET("pokemon/{id}") // 'pokemon' debe estar en minúsculas
    @GET("pokemon")fun getPokemonById():Call<PokemonRespuesta> // Poner "id" dentro de las comillas y corregir la declaración del parámetro
}
