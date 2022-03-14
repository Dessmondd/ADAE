package com.example.adae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adae.interfaces.PokeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

}