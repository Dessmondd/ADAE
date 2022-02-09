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
import com.squareup.picasso.Picasso


class Coleecion: AppCompatActivity() {
    // Initializing the ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coleecion)

        // getting ImageView by its id
        var rImage = findViewById<ImageView>(R.id.rImage)


        // we will get the default FirebaseDatabase instance
        val firebaseDatabase = FirebaseDatabase.getInstance()

        // we will get a DatabaseReference for the database root node
        val databaseReference = firebaseDatabase.reference

        // Here "image" is the child node value we are getting
        // child node data in the getImage variable

        val getImage = databaseReference.child("pidgey")
        // Adding listener for a single change
        // in the data at this location.
        // this listener will triggered once
        // with the value of the data at the location


        val activity = this
        getImage.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                val link = dataSnapshot.getValue(String::class.java)

                // loading that data into rImage
                // variable which is ImageView
                Glide.with(activity).load(getImage).into(rImage)

            }

            // this will called when any problem
            // occurs in getting data
            override fun onCancelled(databaseError: DatabaseError) {
                // we are showing that error message in toast
                Toast.makeText(this@Coleecion, "Error Loading Image", Toast.LENGTH_SHORT).show()
            }
        })

    }




}


