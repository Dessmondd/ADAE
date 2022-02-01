package com.example.adae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Coleecion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coleecion)

        loadFotos()
    }

    fun loadFotos() {
        val firebaseDatabase: DatabaseReference = FirebaseDatabase.getInstance()

        // we will get a DatabaseReference for the database root node
        val databaseReference: DatabaseReference = firebaseDatabase.getReference()


        // recuperas el valor
        var poke_array_ultra = mDatabase.child("ultra").child(userId).get().addOnSuccessListener {
            Log.i("firebase", "Got value ${it.value}")
        }.addOnFailureListener {
            Log.e("firebase", "Error getting data", it)
        }
        for (num 0..poke_array_ultra.size - 1){
            val dex = pok_raro.get(num)
        }
    }
}


