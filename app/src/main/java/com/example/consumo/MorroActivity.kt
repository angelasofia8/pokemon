package com.example.consumo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.consumo.databinding.ActivityMorroBinding
import com.google.android.gms.maps.model.LatLng

class MorroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMorroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMorroBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("latitud", 2.444722505637696)
            intent.putExtra("longitud", -76.60010447322854)
            intent.putExtra("title", "Estoy en el Morro")

            // Iniciar la actividad con el Intent
            startActivity(intent)
        }
    }
}