package com.example.adae

import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
        binding = ActivityColeecionBinding.inflate(layoutInflater)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        val width = dm.widthPixels
        val height = dm.heightPixels

        window.setLayout((width * .8).toInt(), (height * .6).toInt())
        val extras = intent.extras
        if (extras != null){
            var data: String? = extras!!.getString("id")
            if(data != null){
                loadWithGlide(data)

            }
        }

        // getting ImageView by its id
        // we will get the default FirebaseDatabase instance
        val firebaseDatabase = FirebaseDatabase.getInstance()

        // we will get a DatabaseReference for the database root node
        val databaseReference = firebaseDatabase.reference
    }


    fun loadWithGlide(id : String) {

        // This loop will create 20 Views containing
        // the image with the count of view

        val storageReference = Firebase.storage.reference //.toString() + "/comunes/#016-Pidgey.png"//Firebase.storage.reference
        var comunes =storageReference.child(getString(R.string.cartas))


        val firebaseDatabase = FirebaseDatabase.getInstance()
        val databaseReference = firebaseDatabase.reference
        val getImage = databaseReference.child("comunes/" + id + ".png")

        // [START storage_load_with_glide]
        // Reference to an image file in Cloud Storage
        Glide.with(this).load(getImage).into(findViewById<ImageView>(R.id.popup))

    }

}