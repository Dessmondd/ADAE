package com.example.adae.models

class Pokemon {

    private lateinit var id: String
    private lateinit var name : String

    fun getId() : String{
        return id
    }

    fun getName() : String{
        return name
    }

    fun setId(new_id : String){
        id = new_id
    }

    fun setName(new_name : String){
        name = new_name
    }


}