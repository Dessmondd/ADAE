package com.example.adae.ArenaFragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.adae.R
import com.example.adae.pop_up2


class SecFragment : Fragment() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            val v = inflater.inflate(R.layout.fragment_sec,container, false)
            //return inflater.inflate(R.layout.fragment_sec, container, false)

            val botton = v.findViewById<ImageButton>(R.id.ciudadverde)
            botton.setOnClickListener{
                val intent = Intent(context, pop_up2::class.java)
                startActivity(intent)
            }
            return v
        }




}