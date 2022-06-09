package com.example.adae

import android.content.Context
import android.content.Intent
import android.icu.number.NumberFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.adae.databinding.CardviewBinding
import com.example.adae.models.PokemonRecycler
import com.squareup.picasso.Picasso

class AlumnoAdapter2 (private val context : Context, private val mList: List<PokemonRecycler>, private val img: ImageView, private val img2: ImageView, private val img3: ImageView, private val img4: ImageView , private val img5: ImageView, private val img6: ImageView) :
    RecyclerView.Adapter<AlumnoAdapter2.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            AlumnoAdapter2.ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mList[position]
        val url = item.url.downloadUrl.addOnSuccessListener {

            val imgcarta = it
            Glide.with(context)
                .load(it)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.img_android2)
            holder.img_android2.id = position
            holder.img_android2.setOnClickListener({

                if (img.drawable == null)
                {
                    Glide.with(context)
                        .load(imgcarta)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(img)
                }
                else if(img2.drawable == null){
                    Glide.with(context)
                        .load(imgcarta)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(img2)
                }
                else if(img3.drawable == null){
                    Glide.with(context)
                        .load(imgcarta)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(img3)
                }
                else if(img4.drawable == null){
                    Glide.with(context)
                        .load(imgcarta)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(img4)
                }
                else if(img5.drawable == null){
                    Glide.with(context)
                        .load(imgcarta)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(img5)
                }
                else if(img6.drawable == null){
                    Glide.with(context)
                        .load(imgcarta)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(img6)
                }







                //img.setImageResource(R.drawable.arena_button)

            })
        }.addOnFailureListener {
            // Handle any errors
            // Download directly from StorageReference using Glide
        }



    }
    override fun getItemCount(): Int = mList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = CardviewBinding.bind(view)

        var img_android2: ImageView

        init {
            img_android2 =
                view.findViewById<View>(R.id.imageViewIdCard) as ImageView


        }

    }

}
