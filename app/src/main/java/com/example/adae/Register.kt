package com.example.adae

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class Register : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        supportActionBar?.hide()
    }




    fun onClickNext(view: android.view.View) {
            val email : EditText = findViewById(R.id.usuarioEr);
            //Hay que poner minimo 6 caracteres sino se crashea
            val passw : EditText = findViewById(R.id.passwordEr);
            var trofeos : String = "0"
            //Comprobamos que los campos no son nulos
            if (email.text != null && passw.text != null){
                //Comprobamos que los campos no son vacios
                var emailString = email.text.toString();
                var passwString = passw.text.toString();
                if(emailString != "" && passwString != ""){
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailString,passwString).addOnCompleteListener {
                        if (it.isSuccessful){
                            register()
                            db.collection("users").document(email.text.toString()).set (hashMapOf("email" to email.text.toString(),
                                "password" to passw.text.toString(), "cartas" to trofeos))
                        } else {
                            ShowError()

                        }
                    }
                }
            } else{

            }
    }
      private fun register(){
        var register = Intent(this, login::class.java)
        startActivity(register)


    }

    private fun ShowError(){

        var builder = AlertDialog.Builder(this)
        val language = Locale.getDefault().getDisplayLanguage().toString()

        var tittle="Error"
        var msg="Puede que no haya conexión con la base de datos o compruebe que el mail introducido existe o que la contraseña introducida tenga 6 carateres o más"
        var button="Aceptar"
        if(language == "English"){
            tittle ="Error"
            msg="There might be no connection with the database or check that the mail exists as well as that the password has 6 or more digits"
            button="Acept"
        }
        if(language == "Deutsch"){
            tittle="Error"
            msg="Möglicherweise besteht keine Verbindung zur Datenbank oder überprüfen Sie, ob die E-Mail existiert und ob das Passwort 6 oder mehr Ziffern hat"
            button="akzeptieren"
        }

        builder.setTitle(tittle )
        builder.setMessage(msg)
        builder.setPositiveButton(button, null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

fun onClickvolverLogin(view: android.view.View ){
    val volverLogin = Intent(this, login::class.java).apply {

    }
    startActivity(volverLogin)
}

}