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

    fun inserData2(code:Int,name:String,tel:Int,addres:String,ciud:String):Long{
        openBdWr()

        val contenedor2 = ContentValues()
        contenedor2.put("cod",code)
        contenedor2.put("nombre",name)
        contenedor2.put("telefono",tel)
        contenedor2.put("direccion",addres)
        contenedor2.put("ciudad",ciud)

        val resul= bd.insert("Data",null,contenedor2)

        return resul
    }
    fun inserData3(title:String,longitud:Double,latitud:Double):Long{
        openBdWr()

        val contenedor3 = ContentValues()
        contenedor3.put("title",title)
        contenedor3.put("longitud",longitud)
        contenedor3.put("latitud",latitud)


        val resul= bd.insert("mapa",null,contenedor3)

        return resul
    }
}


