package com.aphamogged.pokedex.model

import com.google.gson.annotations.SerializedName

data class Pokemon (
    @SerializedName("name")  val nome: String = "",
    @SerializedName("entry_number") val numeroDex: String = "",
    @SerializedName("url")    val url: String = "",
){

}