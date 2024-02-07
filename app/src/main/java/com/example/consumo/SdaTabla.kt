package com.example.consumo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.consumo.databinding.ActivitySdaTablaBinding
import com.example.consumo.model.ManagerBd

class SdaTabla : AppCompatActivity() {

    private lateinit var  binding: ActivitySdaTablaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySdaTablaBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val btn = binding.botn

        btn.setOnClickListener(){
            val code = binding.cp1.text.toString()
            val name = binding.cp2.text.toString()
            val tel = binding.cp3.text.toString()
            val addres = binding.cp4.text.toString()
            val ciud = binding.cp5.text.toString()

            if(code.isEmpty() || name.isEmpty() || tel.isEmpty() || addres.isEmpty() || ciud.isEmpty()){
                Toast.makeText(this,"El campo no puede estar vacio",Toast.LENGTH_SHORT).show()
            }else{
                val manager = ManagerBd(this)
                manager.inserData2(code.toInt(),name,tel.toInt(),addres,ciud)
                Toast.makeText(this,"Base de Datos Creada", Toast.LENGTH_SHORT).show()
            }


        }

        binding.botn2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.botn3.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
    }

}