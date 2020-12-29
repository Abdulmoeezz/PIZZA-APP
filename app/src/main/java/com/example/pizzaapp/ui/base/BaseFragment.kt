package com.example.pizzaapp.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pizzaapp.MainActivity

open class BaseFragment : Fragment() {

    var baseActivity: BaseActivity? = null
        get() = (getActivity() as BaseActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    fun getMainActivity() : MainActivity {
        return MainActivity()
    }

}