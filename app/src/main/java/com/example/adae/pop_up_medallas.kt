package com.example.adae

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.adae.PopUpArenas.*
import com.example.adae.PopUpEntrenadores.*
import com.example.adae.databinding.ActivityColeecionBinding


class pop_up_medallas : AppCompatActivity() {
    private lateinit var binding: ActivityColeecionBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_pop_up_medallas)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = ActivityColeecionBinding.inflate(layoutInflater)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        val width = dm.widthPixels
        val height = dm.heightPixels

        window.setLayout((width * 0.8).toInt(), (height * 0.4).toInt())


        val image = findViewById<ImageView>(R.id.erikacard)


        val button3 = findViewById<ImageButton>(R.id.fucsia)
        button3.setOnClickListener(){
            val intent = Intent(this, pop_up_koga::class.java)
            startActivity(intent)
        }

        val button4 = findViewById<ImageButton>(R.id.canela)
        button4.setOnClickListener(){
            val intent = Intent(this, pop_up_blaine::class.java)
            startActivity(intent)
        }
        val button5 = findViewById<ImageButton>(R.id.azafran)
        button5.setOnClickListener(){
            val intent = Intent(this, pop_up_sabrina::class.java)
            startActivity(intent)
        }
        val button6 = findViewById<ImageButton>(R.id.verde)
        button6.setOnClickListener(){
            val intent = Intent(this, pop_up_giovanni::class.java)
            startActivity(intent)
        }
        val button7 = findViewById<ImageButton>(R.id.azulona)
        button7.setOnClickListener(){
            val intent = Intent(this, pop_up_erika::class.java)
            startActivity(intent)
        }
        val button8 = findViewById<ImageButton>(R.id.plateada)
        button8.setOnClickListener(){
            val intent = Intent(this, pop_up_brock::class.java)
            startActivity(intent)
        }

    }

}