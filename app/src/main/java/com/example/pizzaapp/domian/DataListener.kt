package com.example.pizzaapp.domian

import androidx.lifecycle.LiveData
import com.example.pizzaapp.data.response.ProductResponse

interface DataListener {

    fun onStarted()
    fun onSuccess(response: LiveData<ProductResponse>)
    fun onFailure(message:String)


}