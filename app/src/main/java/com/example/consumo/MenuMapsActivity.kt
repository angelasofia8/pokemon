package com.example.consumo

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.consumo.databinding.ActivityMenuMapsBinding

class MenuMapsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuMapsBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuMapsBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        // Inicializar el reproductor de audio
        mediaPlayer = MediaPlayer.create(this, R.raw.audioclave) // Reemplaza "tu_audio" con el nombre de tu archivo de audio en la carpeta res/raw

        binding.button1.setOnClickListener {
            val intent = Intent(this, MorroActivity::class.java)
            startActivity(intent)
            // Reproducir audio al cambiar a la actividad MorroActivity
            playAudio()
        }

        binding.button2.setOnClickListener {
            val intent = Intent(this, CaldasActivity::class.java)
            startActivity(intent)
            // Reproducir audio al cambiar a la actividad CaldasActivity
            playAudio()
        }

        binding.button3.setOnClickListener {
            val intent = Intent(this, SenaActivity::class.java)
            startActivity(intent)
            // Reproducir audio al cambiar a la actividad SenaActivity
            playAudio()
        }
    }

    // Método para reproducir audio
    private fun playAudio() {
        // Verificar si el reproductor está reproduciendo
        if (mediaPlayer.isPlaying) {
            // Pausar y reiniciar desde el principio
            mediaPlayer.pause()
            mediaPlayer.seekTo(0)
        } else {
            // Iniciar la reproducción desde el principio
            mediaPlayer.start()
        }
    }

    override fun onDestroy() {
        // Liberar los recursos del reproductor de audio al destruir la actividad
        mediaPlayer.release()
        super.onDestroy()
    }
}
