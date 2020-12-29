package com.example.pizzaapp.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaapp.R
import com.example.pizzaapp.`object`.AppInstance
import com.example.pizzaapp.adapter.CartAdapter
import com.example.pizzaapp.adapter.ProductAdapter
import com.example.pizzaapp.databinding.FragmentOrderBinding
import com.example.pizzaapp.domian.TotalPrizeListener
import com.example.pizzaapp.ui.base.BaseFragment

class OrderFragment: BaseFragment(), TotalPrizeListener {

    lateinit var adapter : CartAdapter
    var totalPrize:Long = 0

    lateinit var binding: FragmentOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
    }


    fun setUpAdapter(){
        binding.recyclerView.layoutManager = LinearLayoutManager(getMainActivity(), LinearLayoutManager.VERTICAL ,false)
        adapter = activity?.let { CartAdapter(it,this) }!!
        adapter.setProductList(AppInstance.instance.cartProducts)
        binding.recyclerView.adapter = adapter
    }

    override fun listenerPrize(prize: Long) {
        totalPrize += prize
        binding.totalPrice.setText("${totalPrize} USD")
    }


}