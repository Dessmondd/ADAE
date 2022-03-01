package com.example.adae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Register : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
    }




    fun onClickNext(view: android.view.View) {
            val email : EditText = findViewById(R.id.email);
            //Hay que poner minimo 6 caracteres sino se crashea
            val passw : EditText = findViewById(R.id.editTextTextPassword);
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
                                "password" to passw.text.toString(), "trofeos" to trofeos))
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
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error con Firebase")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

fun onClickvolverLogin(view: android.view.View ){
    val volverLogin = Intent(this, login::class.java).apply {

    }
    startActivity(volverLogin)
}

}