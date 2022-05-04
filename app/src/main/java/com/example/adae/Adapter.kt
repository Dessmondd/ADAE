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
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.adae.databinding.CardviewBinding
import com.example.adae.models.PokemonRecycler
import com.squareup.picasso.Picasso

class AlumnoAdapter (private val context : Context, private val mList: List<PokemonRecycler>) :
    RecyclerView.Adapter<AlumnoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            AlumnoAdapter.ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]

        val url = item.url.downloadUrl.addOnSuccessListener {
            // Got the download URL for 'users/me/profile.png'
            // (See MyAppGlideModule for Loader registration)
            Glide.with(context)
                .load(it)
                .into(holder.img_android)
            // [END storage_load_with_glide]

            holder.img_android.id = position

            holder.img_android.setOnClickListener({
                val intent = Intent(context, pop_up::class.java)
                intent.putExtra("data", item.name)
                context.startActivity(intent)
            })
        }.addOnFailureListener {
            // Handle any errors
            // Download directly from StorageReference using Glide
        }



    }
    override fun getItemCount(): Int = mList.size
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = CardviewBinding.bind(view)

        var img_android: ImageView

        init {
            img_android =
                view.findViewById<View>(R.id.imageViewIdCard) as ImageView


        }

    }
}
