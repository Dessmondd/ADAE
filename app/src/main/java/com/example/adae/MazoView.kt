package com.example.adae

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adae.databinding.ActivityMazoBinding
import com.example.adae.models.PokemonRecycler
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList


class MazoView : AppCompatActivity() {

    private lateinit var binding: ActivityMazoBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    var recyclerView: RecyclerView? = null
    var Manager: GridLayoutManager? = null
    var adapter: Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        val language = Locale.getDefault().getDisplayLanguage().toString()
        binding = ActivityMazoBinding.inflate(layoutInflater)
        loadWithGlide()
        supportActionBar?.hide()
        checkSession()
        val firebaseDatabase = FirebaseDatabase.getInstance()
        val databaseReference = firebaseDatabase.reference
        val activity = this
        val fab: View = findViewById(R.id.fab2)
        fab.setOnClickListener { view ->
            inicio()
        }
    }

    fun loadWithGlide() {
        val language = Locale.getDefault().getDisplayLanguage().toString()
        val view = binding.root
        setContentView(view)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview2)
        recyclerview.layoutManager = GridLayoutManager(this, 3)
        val data = ArrayList<PokemonRecycler>()
        val storageReference = Firebase.storage.reference
        var comunes =storageReference.child(getString(R.string.cartas))
        var comunesde = storageReference.child(getString(R.string.cartasde))
        var comunesen = storageReference.child(getString(R.string.cartasen))
        var a = comunes
        var b = arrayOf(a)
        for(i in 1..30){
            var pidgey = comunes.child("/"+i.toString() +".png")
            if(language == "English"){
                pidgey = comunesen.child("/"+i.toString() +".png")
            }
            if(language == "Deutsch"){
                pidgey = comunesde.child("/"+i.toString() +".png")
            }

            data.add(PokemonRecycler(i.toString(), pidgey))
        }
        val aaa = findViewById<ImageView>(R.id.container1)
        val a2 = findViewById<ImageView>(R.id.container2)
        val a3 = findViewById<ImageView>(R.id.container3)
        val a4 = findViewById<ImageView>(R.id.container4)
        val a5 = findViewById<ImageView>(R.id.container5)
        val a6 = findViewById<ImageView>(R.id.container6)



        aaa.setOnClickListener(){
            aaa.setImageDrawable(null)
        }
        a3.setOnClickListener(){
            a3.setImageDrawable(null)
        }
        a2.setOnClickListener(){
            a2.setImageDrawable(null)
        }
        a4.setOnClickListener(){
            a4.setImageDrawable(null)
        }
        a5.setOnClickListener(){
            a5.setImageDrawable(null)
        }
        a6.setOnClickListener(){
            a6.setImageDrawable(null)
        }


        val adapter= AlumnoAdapter2(this@MazoView ,data, aaa,a2,a3,a4,a5,a6)
        recyclerview.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().
        baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.drawer2, menu)
        return true;
    }


    fun inicio(){
        val inicio = Intent(this, logout::class.java)
        startActivity(inicio)
    }
    fun borrar(view: android.view.View){
        val a2 = findViewById<ImageView>(R.id.container2)
        a2.setImageDrawable(null)
    }

    private fun checkSession() {
        val preferences =
            getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE)
        val email = preferences.getString("email", null);
        if (email != null) {
            logout()
        }
    }
}
