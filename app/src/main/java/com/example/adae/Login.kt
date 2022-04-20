package com.example.adae

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class login : AppCompatActivity() {
    private val GOOGLE_SIGN_IN = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        checkSession()
        supportActionBar?.hide()
        val googleConf = GoogleSignInOptions.
        Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
        requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail().
            build()
        val gClient = GoogleSignIn.getClient(this,
            googleConf)
        val registerButton : ImageButton = findViewById(R.id.buttonId);
        registerButton.setOnClickListener{
            gClient.signOut()
            val intent = gClient.getSignInIntent()
            startActivityForResult(intent, 100)
        }




        val constraintLayout = findViewById<ConstraintLayout>(R.id.layout)
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(4000)
        animationDrawable.start()
    }
//Login simple
    fun onClickLoginNext(view: View) {
        var email: EditText = findViewById(R.id.usuario);
        var passw: EditText = findViewById(R.id.password);
        if (email.text.isNotEmpty() && passw.text.isNotEmpty()) {
            try {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(email.text.toString(), passw.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            login()
                        } else {
                            //error
                            ShowAlert2()
                        }
                    }

            } catch (ex: Exception) {
                ShowAlert2()
            }


        }

    }
private fun logout(){
    var logout = Intent(this, Menu::class.java)
    startActivity(logout)
}
    private fun login() {
        var login = Intent(this, logout::class.java)
        startActivity(login)
    }


    //En caso de error, se muestra un mensaje

    private fun ShowAlert2() {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Email & Password erróneos")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
//Comprueba si hay una sesión activa
    private fun checkSession() {
        val preferences =
            getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE)
        val email = preferences.getString("email", null);
        if (email != null) {
            logout()
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GOOGLE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                if (account != null) {
                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().signInWithCredential(credential)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                login()
                            } else {

                            }


                        }
                }
            } catch (e: ApiException) {

            }
        }
    }

    fun irRegistro(view: android.view.View){
        var irRegistro = Intent (this, Register::class.java).apply{
        }
        startActivity(irRegistro)
    }
    fun irRecuperar(view: android.view.View){
        var recuperar= Intent (this, RecoverPassword::class.java).apply{

        }
        startActivity(recuperar)
    }

}


