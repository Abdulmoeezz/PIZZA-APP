package com.example.pizzaapp.domian

import com.example.pizzaapp.data.repositories.PizzaRepository
import com.example.pizzaapp.data.response.ProductResponse
import io.reactivex.rxjava3.core.Observable

public  class pizzaCallBackImplementation : pizzaCallBack{
    private var pizzaRepository:PizzaRepository? = null

init {
    pizzaRepository = PizzaRepository.getInstance()
}


    override fun pizzalistAction(): String{
      return  ""

    }


}