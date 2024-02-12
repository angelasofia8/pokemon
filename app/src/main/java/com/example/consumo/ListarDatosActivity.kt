package com.example.consumo

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.consumo.databinding.ActivityListarDatosBinding
import com.example.consumo.model.Ciudad
import com.example.consumo.model.ManagerBd

class ListarDatosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListarDatosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarDatosBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val manager = ManagerBd(this)
        val arrayciudad = manager.getData()

        val listCiudad = binding.listVCiudad
        val arrayAdapter = ArrayAdapter<Ciudad>(this,android.R.layout.simple_list_item_1,arrayciudad)

        listCiudad.adapter = arrayAdapter

        Toast.makeText(this,"Datos Listados",Toast.LENGTH_SHORT).show()
    }
}