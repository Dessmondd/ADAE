package com.example.adae

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        supportActionBar?.hide()
        music()
        Handler().postDelayed({
            val intent = Intent(this, Main::class.java)
            startActivity(intent)
            finish()
            music()
        },3000)
    }


    fun music(){
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.backgroundsound)
        mediaPlayer.isLooping;
        mediaPlayer.start()
    }

//hola
}