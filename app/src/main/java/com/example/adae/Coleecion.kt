package com.example.adae
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adae.databinding.ActivityColeecionBinding
import com.example.adae.interfaces.PokemonAPI
import com.example.adae.models.Pokemon
import com.example.adae.models.PokemonRecycler
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.*
import com.google.firebase.storage.ktx.storage
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Coleecion: AppCompatActivity() {
    // Initializing the ImageView
    private lateinit var binding: ActivityColeecionBinding
    var recyclerView: RecyclerView? = null
    var Manager: GridLayoutManager? = null
    var adapter: Adapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColeecionBinding.inflate(layoutInflater)

    loadWithGlide()
        // getting ImageView by its id
        // we will get the default FirebaseDatabase instance
        val firebaseDatabase = FirebaseDatabase.getInstance()

        // we will get a DatabaseReference for the database root node
        val databaseReference = firebaseDatabase.reference

        // Here "image" is the child node value we are getting
        // child node data in the getImage variable

        //val getImage = databaseReference.child("pidgey")
        // Adding listener for a single change
        // in the data at this location.
        // this listener will triggered once
        // with the value of the data at the location
        val activity = this
        // Reference to an image file in Cloud Storage

        //Glide.with(activity).load(getImage).into(rImage)

/*
        getImage.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                val link = dataSnapshot.getValue(String::class.java)

                // loading that data into rImage
                // variable which is ImageView
                Glide.with(activity).load("https://firebasestorage.googleapis.com/v0/b/pokemoncard-f77c4.appspot.com/o/comunes%2F%23016-Pidgey.png?alt=media&token=940d67dc-4804-4fc2-b1e3-0074fa418790").into(rImage)

            }

            // this will called when any problem
            // occurs in getting data
            override fun onCancelled(databaseError: DatabaseError) {
                // we are showing that error message in toast
                Toast.makeText(this@Coleecion, "Error cogiendo la imagen de la base de datos", Toast.LENGTH_SHORT).show()
            }
        })
*/
    }

    fun loadWithGlide() {

        val view = binding.root
        setContentView(view)
        // [START storage_load_with_glide]
        // Reference to an image file in Cloud Storage
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        // this creates a vertical layout Manager
        recyclerview.layoutManager = GridLayoutManager(this, 2)
        // ArrayList of class ItemsViewModel
        val data = ArrayList<PokemonRecycler>()
        // This loop will create 20 Views containing
        // the image with the count of view

        val storageReference = Firebase.storage.reference //.toString() + "/comunes/#016-Pidgey.png"//Firebase.storage.reference
        var comunes =storageReference.child(getString(R.string.comunes))

        var a = comunes
       var b = arrayOf(a)
        //
        // var retr = getRetrofit()
        //var pokeApi = retr.create(PokemonAPI::class.java)

        for(i in 1..31){

            var pidgey = comunes.child("/"+i.toString() +".png")

//Llamar nombre desde Pokeapi
            /*var nombre = ""
            var callPoke = pokeApi.getPokemonByDexNumOrName(i.toString())
            callPoke.execute()
            object: Callback<Pokemon> {
                override fun onResponse(
                    call: Call<Pokemon>?,
                    response: Response<Pokemon>?
                ){
                    var pokemon : Pokemon? = response?.body()
                    if(pokemon?.name != null){
                        nombre = pokemon.name!!
                    }
                }
                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                }

            }


*/


           data.add(PokemonRecycler("Pokemon", pidgey))

           /*
           val imageView = findViewById<ImageView>(R.id.rImage)

                val url = pidgey.downloadUrl.addOnSuccessListener {
                    // Got the download URL for 'users/me/profile.png'
                    // (See MyAppGlideModule for Loader registration)

                    // [END storage_load_with_glide]
                }.addOnFailureListener {
                    // Handle any errors
                    // Download directly from StorageReference using Glide
                }
           * */

        }

        // ImageView in your Activity

        // This will pass the ArrayList to our Adapter
        val adapter = AlumnoAdapter(this@Coleecion ,data)
        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }

private fun getRetrofit():Retrofit{
    return Retrofit.Builder().
            baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create()).build()

}

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.drawer2, menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val item_selected: Int = item.itemId
        if (item_selected == R.id.inicio) {
                inicio()
        }


        return super.onOptionsItemSelected(item)
    }

    fun inicio(){
        val inicio = Intent(this, logout::class.java)
        startActivity(inicio)
    }

}


