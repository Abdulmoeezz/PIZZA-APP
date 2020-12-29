package com.example.pizzaapp.domian

import com.example.pizzaapp.data.response.Product

interface CartItemListener {
    fun addOrRemoveListener(item : Product ,willRemove:Boolean)
}