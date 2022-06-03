package com.example.adae

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.adae.models.Board
import java.util.*


class MainActivity : AppCompatActivity(), ViewerPagerAdapter2.OnItemSelected {

    private lateinit var boardList: List<Board>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)
        supportActionBar?.hide()
        val language = Locale.getDefault().getDisplayLanguage().toString()
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
            .putBoolean("isFirstRun", false).commit()


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }
        else{
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        if(language != "English"){
            boardList = listOf(
                Board(
                    fondo = R.drawable.gradient_list,
                    imagen = R.drawable.pikachugif,
                    titulo = "¡Bienvenido a Pokémon!",
                    descripcion = "¡Únete al mundo de las cartas de Pokémon y pasalo en grande!"
                ),
                Board(
                    fondo = R.drawable.gradient_list,
                    imagen = R.drawable.gifonboard,
                    titulo = "Pokemon's, mazos, colecciones...",
                    descripcion = "Montones de Pokémon te están esperando dentro, elige tus mejores cartas y crea tu mazo"

                ),
                Board(
                    fondo = R.drawable.gradient_list,
                    imagen = R.drawable.gif4,
                    titulo = "¡Mejor con amigos!",
                    descripcion = "¡Miles de jugadores ya lo juegan, comparte, disfruta y pasa un buen rato, revive esos momentos de la infancia"
                )

            )

        }
        else{
            boardList = listOf(
                Board(
                    fondo = R.drawable.gradient_list,
                    imagen = R.drawable.pikachugif,
                    titulo = "Welcome to Pokemon!",
                    descripcion = "Join us in a world of cards and have fun!"
                ),
                Board(
                    fondo = R.drawable.gradient_list,
                    imagen = R.drawable.gifonboard,
                    titulo = "Pokemon's, decks, collections...",
                    descripcion = "Tons of Pokemon are waiting inside, choose your best cards and create your deck!"

                ),
                Board(
                    fondo = R.drawable.gradient_list,
                    imagen = R.drawable.gif4,
                    titulo = "Better with friends!",
                    descripcion = "Thousands of people are already playing the game, share, enjoy and have a fun time, revive those nostalgic moments!"
                )

            )

        }
       

        val adapter = ViewerPagerAdapter2(boardList, this)

        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        viewPager.adapter = adapter
        viewPager.orientation= ViewPager2.ORIENTATION_HORIZONTAL
    }

    override fun onClickListener(position: Int) {
        if(position == boardList.size -1){
            onFinish()
            finish()
        }
        else{
            val viewPager = findViewById<ViewPager2>(R.id.view_pager)
            viewPager.setCurrentItem(position + 1, true)
        }

    }
    fun onFinish(){
        val onFinish = Intent(this, login::class.java)
        startActivity(onFinish)
    }
}