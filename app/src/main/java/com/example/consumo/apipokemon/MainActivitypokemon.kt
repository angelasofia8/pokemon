package com.example.consumo.apipokemon

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.consumo.R
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivitypokemon : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activitypokemon)
        val text = findViewById<TextView>(R.id.textView)
        val img = findViewById<ImageView>(R.id.img)
        val retrofit=Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(PokemonApiService::class.java)
        val call = service.getPokemonById()//consulta el pokemon

        call.enqueue(object : Callback<PokemonRespuesta>{
            override fun onResponse(call: Call<PokemonRespuesta>,response: Response<PokemonRespuesta>){
                if (response.isSuccessful) {
                    val pokemonRespuesta: PokemonRespuesta? = response.body()


                    //haz lo que quieras con la informacion del pokemon
                    Toast.makeText(this@MainActivitypokemon, "el consumido es $pokemonRespuesta", Toast.LENGTH_SHORT).show()
                    text.text = pokemonRespuesta.toString()
                    Picasso.get()
                        .load("https://centrodepsicologiademadrid.es/wp-content/uploads/2018/11/rabiaytristeza.jpg")
                        .into(img)
                }else{
                    //maejar errores
                }
            }

            override fun onFailure(call: Call<PokemonRespuesta>, t: Throwable) {
               //manejar errores de la red
            }
        })

    }
}