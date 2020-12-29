package com.example.pizzaapp.ui.drinks

import androidx.lifecycle.ViewModel
import com.example.pizzaapp.data.repositories.BurgerRepository
import com.example.pizzaapp.data.repositories.DrinkRepository
import com.example.pizzaapp.domian.DataListener

class DrinkViewModel: ViewModel() {

    var listener: DataListener? = null
    fun getDrinkListAction(){
        listener?.onStarted()
        val responseViewModel = DrinkRepository().getDrinkListAction()
        listener?.onSuccess(responseViewModel)
    }

}