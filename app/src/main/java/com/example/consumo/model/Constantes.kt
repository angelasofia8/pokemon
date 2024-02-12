package com.example.consumo.model

class Constantes {

    // Sirve  para que mis constantes sean globales
    companion object{
        const val NOM_BD = "BdAdso"
        const val VERSION_BD = 8
        const val TABLA = "Create table ciudad (cod int, nombre text, codedep int)"
        const val DATA = "Create table Data (cod int, nombre text,telefono int,direccion text, ciudad text)"
        const val MAPA = "Create table mapa (title text, longitud float, latitud float)"
        const val TRAER = "Select * from ciudad"
    }
}