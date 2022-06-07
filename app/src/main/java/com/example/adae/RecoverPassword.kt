package com.example.adae

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.ActivityInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
                        Log.d(TAG, "Email sent")
                    }
                    if(language == "Deutsch"){
                        Log.d(TAG, "EMail gesendet")
                    }
                    login()
                    popuppassword()
                }else{
                    ShowError()
                }


            }
        // Termina de enviar la petición de resetear
    }

    private fun ShowError(){

        var builder = AlertDialog.Builder(this)
        val language = Locale.getDefault().getDisplayLanguage().toString()

        var tittle="Error"
        var msg="El email no existe o está mal escrito"
        var button="Aceptar"
        if(language == "English"){
            tittle ="Error"
            msg="The email does not exist or is not well written"
            button="Acept"
        }
        if(language == "Deutsch"){
            tittle="Error"
            msg="Die E-Mail existiert nicht oder ist nicht gut geschrieben"
            button="akzeptieren"
        }

        builder.setTitle(tittle )
        builder.setMessage(msg)
        builder.setPositiveButton(button, null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
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
        if(language == "Deutsch"){
            text = "EMail zur Kontowiederherstellung erfolgreich gesendet"
        }
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
}