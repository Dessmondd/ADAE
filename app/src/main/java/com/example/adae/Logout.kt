package com.example.adae

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class logout : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logout)
        // check if users is logged or not, if login token doesn't exist user can't skip layouts
        auth= FirebaseAuth.getInstance()
        var currentUser=auth.currentUser

//        Reference should work for now
       // val logout=findViewById<Button>(R.id.logout)

        if(currentUser==null){
            startActivity(Intent(this,login::class.java))
            finish()
        }
        /*logout.setOnClickListener{
            auth.signOut()
            startActivity(Intent(this,login::class.java))
            finish()
        }
    */
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.drawer, menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val item_selected: Int = item.itemId
        if (item_selected == R.id.logout) {
            logoutv2()
        } else if (item_selected == R.id.perfil) {
            inProgress()
        } else if (item_selected == R.id.bomberman){
            inProgress()
        }


        return super.onOptionsItemSelected(item)
    }


    fun MainActivity(view: android.view.View) {
        val logout = Intent(this, login::class.java).apply {
        }
        startActivity(logout)
    }
    private fun register(){
        var register = Intent(this, MainActivity::class.java)
        startActivity(register)
    }
    private fun login(){
        var login = Intent(this, login::class.java)
        startActivity(login)

    }
    private fun home(){
        var home = Intent(this, DrawerActivity::class.java)
        startActivity(home)
    }
     fun coleccion(view: android.view.View){
        val home = Intent(this, Coleecion::class.java).apply{
        }
        startActivity(home)
    }

   fun inProgressv2(view: android.view.View){
        val text = "No disponible en la alpha"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    private fun inProgress(){
        val text = "No disponible en la alpha"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
    fun shop(view: android.view.View){
        var shop = Intent(this, Main::class.java).apply {

        }
        startActivity(shop)
    }
    fun user(view: android.view.View){
        val text = "No disponible en la alpha"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
    fun logoutv2(){
        auth.signOut()
        startActivity(Intent(this,login::class.java))
        finish()
    }
    }
