package com.example.adae.PopUpArenas

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import com.example.adae.R
import com.example.adae.databinding.ActivityColeecionBinding


class pop_up4 : AppCompatActivity() {
    private lateinit var binding: ActivityColeecionBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_pop_up4)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = ActivityColeecionBinding.inflate(layoutInflater)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        val width = dm.widthPixels
        val height = dm.heightPixels

        window.setLayout((width * .9).toInt(), (height * .8).toInt())

    }

}