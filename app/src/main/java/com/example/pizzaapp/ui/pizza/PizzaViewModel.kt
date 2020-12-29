package com.example.pizzaapp.ui.pizza

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.pizzaapp.data.repositories.PizzaRepository
import com.example.pizzaapp.data.response.ProductResponse
import com.example.pizzaapp.domian.DataListener
import com.example.pizzaapp.domian.pizzaCallBackImplementation
import io.reactivex.rxjava3.core.Observable

class PizzaViewModel:ViewModel() {

    var listener:DataListener? = null
    fun getPizzaListAction(){
        listener?.onStarted()
        val loginResponseViewModel = PizzaRepository().getPizzaListAction()
        listener?.onSuccess(loginResponseViewModel)
    }








//    private  var pizzaCallBackImplementation: pizzaCallBackImplementation? = null
//
//    fun pizzaViewModel(){
//        pizzaCallBackImplementation = pizzaCallBackImplementation()
//    }
//
//    fun pizzalistAction(): Observable<ProductResponse>? {
//        return pizzaCallBackImplementation?.pizzalistAction()
//    }


}