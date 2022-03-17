package com.example.adae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onClickNext(view: View) {}

}