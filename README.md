Basurita que puede servir



binding.button1.setOnClickListener {
         handleButtonClick(LatLng(2.444722505637696, -76.60010447322854), "Estoy en el Morro")

           }
         binding.button2.setOnClickListener {
             handleButtonClick(LatLng(2.4419129763765652, -76.60627922923295), "Estoy en el Parque Caldas")
         }
          binding.button3.setOnClickListener {
         handleButtonClick(LatLng(2.4828269969022605, -76.56227794451196), "Estoy en el Sena")
         }


fun handleButtonClick(position: LatLng, title: String) {
            val title = title
            val longitud = position.longitude
            val latitud = position.latitude
            val manager = ManagerBd(this)
            manager.inserData3(title, longitud.toFloat(), latitud.toFloat())
            // Borrar el marcador seleccionado actual
            selectedMarker?.remove()

            // Agregar el nuevo marcador
            selectedMarker = mMap.addMarker(MarkerOptions().position(position).title(title))

            // Mover la cámara al nuevo marcador
            mMap.moveCamera(CameraUpdateFactory.newLatLng(position))
        }
