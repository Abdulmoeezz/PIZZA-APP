package com.example.pizzaapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pizzaapp.R
import com.example.pizzaapp.`object`.AppInstance
import com.example.pizzaapp.data.response.Product
import com.example.pizzaapp.domian.CartItemListener
import com.example.pizzaapp.domian.TotalPrizeListener
import kotlinx.android.synthetic.main.item_rv.view.*
import kotlinx.android.synthetic.main.item_rv_cart.view.*


class CartAdapter (private val context: Context,var totalPrizeListener: TotalPrizeListener) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {


    private var list: ArrayList<Product> = ArrayList()

    fun setProductList(arrayList: ArrayList<Product>){
        this.list = arrayList
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {




        Glide.with(context)
            .load(list[position].image_url)
            .into(holder.image)
        holder.name.text = list[position].name
        holder.price.text = "${list[position].price}"
        totalPrizeListener.listenerPrize(list[position].price)




    }


    override fun getItemViewType(position: Int): Int {
        return position
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_rv_cart,
                parent,
                false
            )
        )
    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name = v.txt_name_!!
        val price = v.txt_prize!!
        val image = v.img_!!
    }


}