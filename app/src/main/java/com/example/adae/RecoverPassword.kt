package com.example.adae

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.ActivityInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.util.*

class RecoverPassword : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    val language = Locale.getDefault().getDisplayLanguage().toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recover)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        supportActionBar?.hide()
    }

    fun sendPasswordReset(view: android.view.View) {
        // Inicia el proceso de restauración de contraseña
        var email: EditText = findViewById(R.id.email);

        Firebase.auth.sendPasswordResetEmail(email.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Email enviado")
                    if(language == "English"){
                        Log.d(TAG, "Email enviado")
                    }
                    login()
                    popuppassword()
                }else{
                    Log.d(TAG, "La cuenta no existe.")
                    if(language == "English"){
                        Log.d(TAG, "Account doesn't exist")
                    }
                }
            }
        // Termina de enviar la petición de resetear
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
    fun popuppassword(){
        var text = "Email de recuperación enviado con éxito"
        if(language == "English"){
            text = "Account recover email sent successfully"
        }
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
}