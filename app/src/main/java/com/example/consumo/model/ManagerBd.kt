package com.example.consumo.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.widget.EditText
import com.example.consumo.MainActivity
import org.w3c.dom.Text

data class ManagerBd(val context: Context) {
    lateinit var bd:SQLiteDatabase

    val bdHelper = BdHelper(context)// llamando a mi conexion

    // metodo para abrir la base de datos en modo escritura
    fun openBdWr(){
        bd = bdHelper.writableDatabase
    }

    // metodo para abrir la base de datos en modo lectura
    fun openBdRd(){
        bd= bdHelper.readableDatabase
    }

    fun insertData(cod:Int,nombre:String,codedep:Int):Long {
        openBdWr()// abrir bd en modo escritura
        //Creo contenedor de valores para insertar data
        val contenedor = ContentValues()
        contenedor.put("cod",cod)
        contenedor.put("nombre",nombre)
        contenedor.put("codedep",codedep)
        //llamo metodo insert

        val resul= bd.insert("ciudad",null,contenedor)

        return  resul

    }
}


