package com.example.consumo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.consumo.databinding.ActivityMainBinding
import com.example.consumo.model.ManagerBd

 class MainActivity : AppCompatActivity() {
    private  lateinit var  binding:ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)



        val btn = binding.btn

        btn.setOnClickListener{
            val cod = binding.camp1.text.toString()
            val nombre = binding.camp2.text.toString()
            val codedep = binding.camp3.text.toString()

            if(cod.isEmpty() || nombre.isEmpty() || codedep.isEmpty()){
                Toast.makeText(this,"El campo no puede estar vacio",Toast.LENGTH_SHORT).show()
            }else{
                val manager = ManagerBd(this)
                manager.insertData(cod.toInt(),nombre,codedep.toInt())
                Toast.makeText(this,"Base de Datos Creada",Toast.LENGTH_SHORT).show()
            }

        }

        binding.btn2.setOnClickListener {
            val intent = Intent(this,SdaTabla::class.java)
            startActivity(intent)
        }
      //  binding.btn3.setOnClickListener {
          //  val intent = Intent(this,MapsActivity::class.java)
           // startActivity(intent)
       // }
        binding.btn4.setOnClickListener {
            val intent = Intent(this,MenuMapsActivity::class.java)
            startActivity(intent)
        }
        binding.btn5.setOnClickListener {
            val intent = Intent(this,ListarDatosActivity::class.java)
            startActivity(intent)
        }

    }
}

