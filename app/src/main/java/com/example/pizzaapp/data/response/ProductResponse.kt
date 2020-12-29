package com.example.pizzaapp.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class ProductResponse {

    @SerializedName("success")
    @Expose
     val success: Boolean? = null

    @SerializedName("data")
    @Expose
    val data: ArrayList<Product>? = null

    @SerializedName("msg")
    @Expose
     val message: String? = null


}