package com.example.adae

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adae.databinding.ActivityColeecionBinding
import com.example.adae.models.PokemonRecycler
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MazoView : AppCompatActivity() {

    private lateinit var binding: ActivityColeecionBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    var recyclerView: RecyclerView? = null
    var Manager: GridLayoutManager? = null
    var adapter: Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = ActivityColeecionBinding.inflate(layoutInflater)
        loadWithGlide()
        supportActionBar?.hide()

        val firebaseDatabase = FirebaseDatabase.getInstance()
        val databaseReference = firebaseDatabase.reference
        val activity = this
        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            inicio()
        }
    }

    fun loadWithGlide() {

        val view = binding.root
        setContentView(view)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = GridLayoutManager(this, 3)
        val data = ArrayList<PokemonRecycler>()
        val storageReference = Firebase.storage.reference
        var comunes =storageReference.child(getString(R.string.cartas))
        var a = comunes
        var b = arrayOf(a)
        for(i in 1..30){
            var pidgey = comunes.child("/"+i.toString() +".png")
            data.add(PokemonRecycler(i.toString(), pidgey))
        }
        val adapter = AlumnoAdapter(this@MazoView ,data)
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

}
