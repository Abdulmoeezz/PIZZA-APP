package com.example.pizzaapp.`object`

import android.util.Log
import com.example.pizzaapp.data.response.Product
import com.google.gson.Gson

class AppInstance {

    var gson:Gson = Gson()

    var cartProducts = ArrayList<Product>()

    fun clearData(){
        cartProducts = ArrayList<Product>()
    }


    fun itemDeleted(itemmm:Product){


        if(cartProducts.size > 0){
            try {
                for (it in cartProducts ) {
                    if (it.id == itemmm.id) {
                        cartProducts.remove(
                            it)
                        Log.d("##","${gson.toJson(cartProducts)}")

                    }
                }

            }catch (e:ConcurrentModificationException ){

            }



        }
    }


    fun itemAdded(item:Product){
        cartProducts.add(item)
    }

    companion object{
        val instance = AppInstance()
    }
}