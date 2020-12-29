package com.example.pizzaapp.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pizzaapp.data.response.ProductResponse
import com.example.pizzaapp.network.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DrinkRepository {


    val showresponse = MutableLiveData<String>()
    val Response = MutableLiveData<ProductResponse>()


    fun getDrinkListAction() : LiveData<ProductResponse> {

        MyApi().getSubCategory(3).enqueue(object : Callback<ProductResponse> {
            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                showresponse.value = "failed"
                Log.e("##E","Error :: ${t.message}")
            }

            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                if(response.isSuccessful){
                    Response.value = response.body()
                    showresponse.value = "Sucesss"
                    Log.e("##E","Response Sucesss :: ${response.body()}")
                }else{
                    showresponse.value = "failed"
                    Log.e("##E","Response UnSucesss :: ${response.errorBody()?.string()}")


                }
            } })
        return  Response
    }


}