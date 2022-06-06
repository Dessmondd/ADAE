package com.example.adae

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager2.widget.ViewPager2
import com.example.adae.PopUpEntrenadores.pop_up_koga
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProgressionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progression)
        supportActionBar?.hide()
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        val tabLayout=findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2=findViewById<ViewPager2>(R.id.view_pager_2)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        val adapter=ViewPagerAdapter(supportFragmentManager,lifecycle)

        viewPager2.adapter=adapter


        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            when(position){
                0->{
                    tab.text="Arena 1"
                    }
                1->{
                    tab.text="Arena 2"
                }
                2->{
                    tab.text="Arena 3"
                }
                3->{
                    tab.text="Arena 4"
                }
                4->{
                    tab.text="Arena 5"
                }
                5->{
                    tab.text="Arena 6"
                }

            }
        }.attach()

        val button = findViewById<Button>(R.id.medallas)
        button.setOnClickListener(){
            val intent = Intent(this, pop_up_medallas::class.java)
            startActivity(intent)
        }

        val button2 = findViewById<Button>(R.id.Entrenadores)
        button2.setOnClickListener(){
            val intent = Intent(this, pop_up_medallas::class.java)
            startActivity(intent)
        }
        val button3 = findViewById<Button>(R.id.Entrenadores)
        button3.setOnClickListener(){
            val intent = Intent(this, Entrenadores::class.java)
            startActivity(intent)
        }
    }


    fun irAtras(view: android.view.View){
        val irAtras = Intent(this,logout::class.java).apply {
        }
        startActivity(irAtras)
    }






}