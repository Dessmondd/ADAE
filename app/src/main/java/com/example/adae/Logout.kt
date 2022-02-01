package com.example.adae

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity


class logout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logout)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.drawer, menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val item_selected: Int = item.itemId
        if (item_selected == R.id.login) {

        } else if (item_selected == R.id.perfil) {

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
    }
