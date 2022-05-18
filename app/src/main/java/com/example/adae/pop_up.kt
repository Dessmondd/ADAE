package com.example.adae

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adae.databinding.ActivityColeecionBinding
import com.example.adae.models.PokemonRecycler
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


class pop_up : AppCompatActivity() {
    private lateinit var binding: ActivityColeecionBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_pop_up)

        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        val width = dm.widthPixels
        val height = dm.heightPixels

        window.setLayout((width * .8).toInt(), (height * .6).toInt())

        loadWithGlide()
        // getting ImageView by its id
        // we will get the default FirebaseDatabase instance
        val firebaseDatabase = FirebaseDatabase.getInstance()

        // we will get a DatabaseReference for the database root node
        val databaseReference = firebaseDatabase.reference
    }


    fun loadWithGlide(id : String) {

        val view = binding.root
        setContentView(view)
        // [START storage_load_with_glide]
        // Reference to an image file in Cloud Storage
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        // this creates a vertical layout Manager
        recyclerview.layoutManager = GridLayoutManager(this, 2)
        // ArrayList of class ItemsViewModel
        val data = ArrayList<PokemonRecycler>()
        // This loop will create 20 Views containing
        // the image with the count of view

        val storageReference = Firebase.storage.reference //.toString() + "/comunes/#016-Pidgey.png"//Firebase.storage.reference
        var comunes =storageReference.child(getString(R.string.cartas))

        var carta = comunes.child("/"+id +".png")

        data.add(PokemonRecycler(id, carta))


        // ImageView in your Activity

        // This will pass the ArrayList to our Adapter
        val adapter = Adapter2(this ,data)
        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter



    }

}