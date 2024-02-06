package com.example.consumo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.consumo.databinding.ActivityMainBinding
import com.example.consumo.model.ManagerBd

class MainActivity : AppCompatActivity() {
    private  lateinit var  binding:ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)



        val btn = binding.btn

        btn.setOnClickListener(){
            val cod = binding.camp1.text.toString().toInt()
            val nombre = binding.camp2.text.toString()
            val codedep = binding.camp3.text.toString().toInt()
            val manager = ManagerBd(this)
            manager.insertData(cod,nombre,codedep)
            Toast.makeText(this,"Base de Datos Creada",Toast.LENGTH_SHORT).show()
        }

    }
}

