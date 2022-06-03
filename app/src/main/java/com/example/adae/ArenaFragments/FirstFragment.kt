package com.example.adae.ArenaFragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.adae.R
import com.example.adae.PopUpArenas.pop_up1


class FirstFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_first, container, false)

        var boton = v.findViewById<ImageButton>(R.id.ciudadazafran)
        boton.setOnClickListener{

            // working not sure why not in v2
            val intent = Intent(context, pop_up1::class.java)
            startActivity(intent)

        }

        return v



    }




    }



