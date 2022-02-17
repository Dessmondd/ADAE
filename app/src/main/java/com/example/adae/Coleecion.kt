package com.example.adae
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.bumptech.glide.Glide
import com.example.adae.models.Pokemon
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.*
import com.google.firebase.storage.ktx.storage
import com.squareup.picasso.Picasso


class Coleecion: AppCompatActivity() {
    // Initializing the ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coleecion)
    loadWithGlide()
        // getting ImageView by its id
        var rImage = findViewById<ImageView>(R.id.rImage)


        // we will get the default FirebaseDatabase instance
        val firebaseDatabase = FirebaseDatabase.getInstance()

        // we will get a DatabaseReference for the database root node
        val databaseReference = firebaseDatabase.reference

        // Here "image" is the child node value we are getting
        // child node data in the getImage variable

        //val getImage = databaseReference.child("pidgey")
        // Adding listener for a single change
        // in the data at this location.
        // this listener will triggered once
        // with the value of the data at the location
        val activity = this
        // Reference to an image file in Cloud Storage

        //Glide.with(activity).load(getImage).into(rImage)

/*
        getImage.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                val link = dataSnapshot.getValue(String::class.java)

                // loading that data into rImage
                // variable which is ImageView
                Glide.with(activity).load("https://firebasestorage.googleapis.com/v0/b/pokemoncard-f77c4.appspot.com/o/comunes%2F%23016-Pidgey.png?alt=media&token=940d67dc-4804-4fc2-b1e3-0074fa418790").into(rImage)

            }

            // this will called when any problem
            // occurs in getting data
            override fun onCancelled(databaseError: DatabaseError) {
                // we are showing that error message in toast
                Toast.makeText(this@Coleecion, "Error cogiendo la imagen de la base de datos", Toast.LENGTH_SHORT).show()
            }
        })
*/
    }

    fun loadWithGlide() {
        // [START storage_load_with_glide]
        // Reference to an image file in Cloud Storage
        val storageReference = Firebase.storage.reference //.toString() + "/comunes/#016-Pidgey.png"//Firebase.storage.reference
        var comunes =storageReference.child(getString(R.string.comunes))
        var a = comunes.listAll()
       var b = arrayOf(a)
        var pidgey = comunes.child("/#016-Pidgey.png")
        var pidgey2 = comunes.child("/#016-Pidgey.png")
        // ImageView in your Activity
        val imageView = findViewById<ImageView>(R.id.rImage)
        val imageView2 = findViewById<ImageView>(R.id.rImage3)
        val url = pidgey.downloadUrl.addOnSuccessListener {
            // Got the download URL for 'users/me/profile.png'
            // (See MyAppGlideModule for Loader registration)
            Glide.with(this /* context */)
                .load(it)
                .into(imageView)
            // [END storage_load_with_glide]
        }.addOnFailureListener {
            // Handle any errors
            // Download directly from StorageReference using Glide
        }
        val url2 = pidgey2.downloadUrl.addOnSuccessListener {
            // Got the download URL for 'users/me/profile.png'
            // (See MyAppGlideModule for Loader registration)
            Glide.with(this /* context */)
                .load(it)
                .into(imageView2)
            // [END storage_load_with_glide]
        }.addOnFailureListener {
            // Handle any errors
            // Download directly from StorageReference using Glide
        }
    }


}


