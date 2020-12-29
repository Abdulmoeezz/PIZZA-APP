package com.example.pizzaapp.util

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment


fun Fragment.navigate(resId: Int, bundle: Bundle? = null) {
    NavHostFragment.findNavController(this).navigate(resId, bundle)
}