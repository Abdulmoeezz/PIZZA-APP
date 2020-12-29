package com.example.pizzaapp.network

import com.example.pizzaapp.data.response.ProductResponse
import io.reactivex.rxjava3.core.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface MyApi {

    @GET("sub_categories/{Id}")
    fun getSubCategory(
        @Path("Id") id:Int
    ): Call<ProductResponse>

    companion object{
        operator  fun invoke():MyApi{
            return RetrofitConnection.connect().create(MyApi::class.java)
        }

    }

}