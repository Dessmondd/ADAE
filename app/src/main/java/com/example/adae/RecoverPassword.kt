package com.example.adae

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class RecoverPassword : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recover)
    }

    fun sendPasswordReset(view: android.view.View) {
        // [START send_password_reset]
        var email: EditText = findViewById(R.id.email);

        Firebase.auth.sendPasswordResetEmail(email.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Email sent.")
                    login()
                }else{
                    Log.d(TAG, "La cuenta no existe.")
                }
            }
        // [END send_password_reset]
    }

    fun login() {
        var irLogin = Intent(this, login::class.java)
        startActivity(irLogin)
    }
    fun volveralLogin(view: android.view.View){
        var volverLogin = Intent(this, login::class.java).apply {

        }
    startActivity(volverLogin)
    }
}