package com.example.adae

import android.content.Intent
import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        val isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
            .getBoolean("isFirstRun", true)

        if (isFirstRun) {
            //show start activity
            startActivity(Intent(this@Splash, MainActivity::class.java))

        }
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        supportActionBar?.hide()
        Handler().postDelayed({
          val intent = Intent(this, login::class.java)
            startActivity(intent)
            finish()
            music()
        },6000)
        
    }

    //need revamp
    fun music(){
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.backgroundsound)
        mediaPlayer.isLooping;
        mediaPlayer.start()
    }

//hola
}