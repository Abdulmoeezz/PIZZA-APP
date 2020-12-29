package com.example.pizzaapp.ui.burger

import androidx.lifecycle.ViewModel
import com.example.pizzaapp.data.repositories.BurgerRepository
import com.example.pizzaapp.data.repositories.PizzaRepository
import com.example.pizzaapp.domian.DataListener

class BurgerViewModel: ViewModel() {


    var listener: DataListener? = null
    fun getBurgerListAction(){
        listener?.onStarted()
        val responseViewModel = BurgerRepository().getBurgerListAction()
        listener?.onSuccess(responseViewModel)
    }





}