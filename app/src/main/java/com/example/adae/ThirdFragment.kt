package com.example.adae


import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton


class ThirdFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_third, container, false)
        val b = inflater.inflate(R.layout.fragment_third, container, false)

        var button = b.findViewById<ImageButton>(R.id.ciudadarenosa)
        button.setOnClickListener{
            val intent = Intent(context, pop_up2::class.java)
            startActivity(intent)

        }
        return b
    }


}