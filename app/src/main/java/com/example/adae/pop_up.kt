package com.example.adae

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
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
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.System.load


class pop_up : AppCompatActivity() {
    private lateinit var binding: ActivityColeecionBinding

    private lateinit var data: String
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_pop_up)
        binding = ActivityColeecionBinding.inflate(layoutInflater)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        val width = dm.widthPixels
        val height = dm.heightPixels

        window.setLayout((width * .8).toInt(), (height * .7).toInt())
        val extras = intent.extras
        if (extras != null){
             data = extras!!.getString("id")!!
            if(data != null){
                loadWithGlide(data)

            }
        }
        val firebaseDatabase = FirebaseDatabase.getInstance()
        val databaseReference = firebaseDatabase.reference
    }

    fun loadWithGlide(id : String) {
        val firebaseDatabase = FirebaseDatabase.getInstance()
        val storageReference = Firebase.storage.reference //.toString() + "/comunes/#016-Pidgey.png"//Firebase.storage.reference
        var comunes =storageReference.child(getString(R.string.cartas))

        supportActionBar?.hide()
        setContentView(R.layout.activity_pop_up)
        binding = ActivityColeecionBinding.inflate(layoutInflater)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        val width = dm.widthPixels
        val height = dm.heightPixels

        window.setLayout((width * .95).toInt(), (height * .75).toInt())

        val getImage =comunes.child( id + ".png")
        val imageView = findViewById<ImageView>(R.id.popup)

        getImage.downloadUrl.addOnSuccessListener {

            Glide.with(this)
                .load(it)
                .into(imageView)

        }.addOnFailureListener {
            // Handle any errors
            // Download directly from StorageReference using Glide
        }

    }

}