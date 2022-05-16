package com.example.adae

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.adae.models.Board


class MainActivity : AppCompatActivity(), ViewerPagerAdapter2.OnItemSelected {

    private lateinit var boardList: List<Board>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }
        else{
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        boardList = listOf(
            Board(
                fondo = R.drawable.gradient_list,
                imagen = R.drawable.pokemon,
                titulo = "Primera",
                descripcion = "First desc"
            ),
            Board(
                fondo = R.drawable.gradient_list,
                imagen = R.drawable.pokeball,
                titulo = "Segunda",
                descripcion = "First desc"
            ),
            Board(
                fondo = R.drawable.gradient_list,
                imagen = R.drawable.pokemon,
                titulo = "Tercera",
                descripcion = "First desc"
            ),
            Board(
                fondo = R.drawable.gradient_list,
                imagen = R.drawable.ciudad_azafran,
                titulo = "Final",
                descripcion = "First desc"
            )
        )

        val adapter = ViewerPagerAdapter2(boardList, this)

        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        viewPager.adapter = adapter
        //viewPager.orientation= ViewPager2.ORIENTATION_VERTICAL
    }

    override fun onClickListener(position: Int) {
        if(position == boardList.size -1){
            onFinish()
        }
        else{
            val viewPager = findViewById<ViewPager2>(R.id.viewPager)
            viewPager.setCurrentItem(position + 1, true)
        }

    }
    fun onFinish(){
        val onFinish = Intent(this, login::class.java)
        startActivity(onFinish)
    }
}