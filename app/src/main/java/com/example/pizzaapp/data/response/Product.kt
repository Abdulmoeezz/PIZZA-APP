package com.example.pizzaapp.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Product {

    @SerializedName("id")
    @Expose
     val id: Int? = null

    @SerializedName("name")
    @Expose
     val name: String? = null

    @SerializedName("price")
    @Expose
     val price: Long = 0

    @SerializedName("image_url")
    @Expose
     val image_url: String? = null
}
