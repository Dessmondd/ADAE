package com.example.adae

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Entrenadores : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        checkSession()
        setContentView(R.layout.entrenadores)
    }

    fun volverAtrás(view: android.view.View){
        val intent = Intent(this, logout::class.java).apply{

        }
        startActivity(intent)
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