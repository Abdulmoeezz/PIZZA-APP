package com.example.pizzaapp.ui.drinks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaapp.R
import com.example.pizzaapp.`object`.AppInstance
import com.example.pizzaapp.adapter.ProductAdapter
import com.example.pizzaapp.data.response.Product
import com.example.pizzaapp.data.response.ProductResponse
import com.example.pizzaapp.databinding.FragmentDrinkBinding
import com.example.pizzaapp.databinding.FragmentOrderBinding
import com.example.pizzaapp.domian.CartItemListener
import com.example.pizzaapp.domian.DataListener
import com.example.pizzaapp.domian.cartListener
import com.example.pizzaapp.ui.base.BaseFragment
import com.example.pizzaapp.ui.burger.BurgerViewModel
import com.example.pizzaapp.ui.pizza.PizzaFragment

class DrinkFragment:BaseFragment() , DataListener , CartItemListener {

    lateinit var binding: FragmentDrinkBinding
    lateinit var viewModel: DrinkViewModel
    lateinit var adapter : ProductAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_drink, container, false)
        viewModel = ViewModelProviders.of(this).get(DrinkViewModel::class.java)
        viewModel.listener = this
        viewModel.getDrinkListAction()
        binding.recyclerView.layoutManager = LinearLayoutManager(getMainActivity(), LinearLayoutManager.VERTICAL ,false)
        adapter = activity?.let { ProductAdapter(it,this) }!!
        binding.recyclerView.adapter = adapter



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStarted() {

    }

    override fun onSuccess(response: LiveData<ProductResponse>) {

        response.observe(this , Observer {
            it.data?.let { it -> adapter.setProductList(it) }
            Log.d("ok","onSuccess : ${it.data}")
        })
    }

    override fun onFailure(message: String) {
    }


    companion object{
        lateinit var cartListener: cartListener
        fun newInstance(cartListenerr: cartListener){
            cartListener = cartListenerr
        }

    }

    override fun addOrRemoveListener(item: Product, willRemove: Boolean) {
        if(willRemove){
            AppInstance.instance.itemDeleted(item)
           cartListener.onCartUpdated("remove")


        }else{
            AppInstance.instance.itemAdded(item)
           cartListener.onCartUpdated("delete")


        }

    }
}