package com.example.consumo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.consumo.databinding.ActivityCaldasBinding


class CaldasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCaldasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCaldasBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.button.setOnClickListener {
            // Crear el Intent y agregar la información como extras
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("latitud", 2.4419129763765652)
            intent.putExtra("longitud", -76.60627922923295)
            intent.putExtra("title", "Estoy en el Parque Caldas")

            // Iniciar la actividad con el Intent
            startActivity(intent)
        }
    }
}

