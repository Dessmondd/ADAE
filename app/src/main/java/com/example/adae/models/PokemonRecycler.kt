package com.example.adae.models

import android.net.Uri
import com.google.firebase.storage.StorageReference

data class PokemonRecycler(
var name : String,
var url : StorageReference
)

