package com.example.pizzaapp.ui.pizza

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import com.example.pizzaapp.R
import com.example.pizzaapp.data.response.ProductResponse

import com.example.pizzaapp.databinding.FragmentPizzaBinding
import com.example.pizzaapp.domian.DataListener
import com.example.pizzaapp.ui.base.BaseFragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaapp.`object`.AppInstance
import com.example.pizzaapp.adapter.ProductAdapter
import com.example.pizzaapp.data.response.Product
import com.example.pizzaapp.domian.CartItemListener
import com.example.pizzaapp.domian.cartListener
import com.google.gson.Gson


class PizzaFragment: BaseFragment(),DataListener, CartItemListener {


    var gson: Gson = Gson()


    lateinit var binding: FragmentPizzaBinding
    lateinit var viewModel:PizzaViewModel
    lateinit var adapter : ProductAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pizza, container, false)
        viewModel = ViewModelProviders.of(this).get(PizzaViewModel::class.java)
        viewModel.listener = this
        viewModel.getPizzaListAction()
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

        cartListener.onCartUpdated("ok")
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
          Log.d("##","Remove ${gson.toJson(AppInstance.instance.cartProducts)}")


      }else{
          AppInstance.instance.itemAdded(item)
          cartListener.onCartUpdated("delete")
          Log.d("##","Added ${gson.toJson(AppInstance.instance.cartProducts)}")


      }

    }

}