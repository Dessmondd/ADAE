package com.example.adae

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
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

            }
        }.attach()



    }

    fun irAtras(view: android.view.View){
        val irAtras = Intent(this,logout::class.java).apply {

        }
        startActivity(irAtras)
    }
    fun medallas(){
        val intent = Intent(this,pop_up_warning::class.java)
        startActivity(intent)
    }




}