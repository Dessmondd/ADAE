package com.example.adae.PopUpEntrenadores

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.adae.R
import com.example.adae.databinding.ActivityColeecionBinding
import java.util.*


class pop_up_erika : AppCompatActivity() {
    private lateinit var binding: ActivityColeecionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val language = Locale.getDefault().getDisplayLanguage().toString()
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_pop_up_erika)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = ActivityColeecionBinding.inflate(layoutInflater)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        val width = dm.widthPixels
        val height = dm.heightPixels

        window.setLayout((width * 0.8).toInt(), (height * 0.4).toInt())

        val view = findViewById<ImageView>(R.id.erikacard3)
        if(language == "English"){
            view.setImageResource(R.drawable.azulonaeng)
        }
        if(language == "Deutsch"){
            view.setImageResource(R.drawable.azulonaaleman)
        }
    }

}