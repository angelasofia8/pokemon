package com.example.consumo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.consumo.databinding.ActivitySenaBinding
import com.google.android.gms.maps.model.LatLng

class SenaActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySenaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySenaBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("latitud", 2.4828269969022605)
            intent.putExtra("longitud", -76.56227794451196)
            intent.putExtra("title", "Estoy en el Morro")

            // Iniciar la actividad con el Intent
            startActivity(intent)
        }
    }
}