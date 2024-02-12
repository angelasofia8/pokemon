package com.example.consumo

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.consumo.databinding.ActivityMenuMapsBinding

class MenuMapsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuMapsBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuMapsBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        // Inicializar el reproductor de audio
        fun audios(cambiar: Int){
            mediaPlayer = MediaPlayer.create(this,cambiar)
        }

        binding.button1.setOnClickListener {
            val intent = Intent(this, MorroActivity::class.java)
            startActivity(intent)
            // Reproducir audio al cambiar a la actividad MorroActivity
            audios(R.raw.morroaudio)
            playAudio()
        }

        binding.button2.setOnClickListener {
            val intent = Intent(this, CaldasActivity::class.java)
            startActivity(intent)
            // Reproducir audio al cambiar a la actividad CaldasActivity
            audios(R.raw.caldasdos)
            playAudio()
        }

        binding.button3.setOnClickListener {
            val intent = Intent(this, SenaActivity::class.java)
            startActivity(intent)
            audios(R.raw.elbicho)
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
