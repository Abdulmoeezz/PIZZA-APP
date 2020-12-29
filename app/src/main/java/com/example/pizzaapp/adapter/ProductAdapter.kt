package com.example.pizzaapp.adapter

import android.content.Context
import android.content.Intent
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
import kotlinx.android.synthetic.main.item_rv.view.*

class ProductAdapter (  private val context: Context, var listener : CartItemListener) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {


    private var list: ArrayList<Product> = ArrayList()

    fun setProductList(arrayList: ArrayList<Product>){
        this.list = arrayList
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        if(AppInstance.instance.cartProducts.any{ it.id == list.get(position).id }){
            holder.addtoCarButton.setText("Added")
            holder.addtoCarButton.setBackground(ContextCompat.getDrawable(context, R.drawable.button_round_green))
        }

        Glide.with(context)
            .load(list[position].image_url)
            .into(holder.image)
        holder.name.text = list[position].name
        holder.price.text = "${list[position].price}"

        holder.addtoCarButton.setOnClickListener {
          if(AppInstance.instance.cartProducts.any{ it.id == list.get(position).id }){
              holder.addtoCarButton.setText("Add")
              holder.addtoCarButton.setBackground(ContextCompat.getDrawable(context, R.drawable.button_round_red))
              listener.addOrRemoveListener(list.get(position),true)

          }else{
              holder.addtoCarButton.setText("Added")
              holder.addtoCarButton.setBackground(ContextCompat.getDrawable(context, R.drawable.button_round_green))
              listener.addOrRemoveListener(list.get(position),false)
          }


        }


    }


    override fun getItemViewType(position: Int): Int {
        return position
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_rv,
                parent,
                false
            )
        )
    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name = v.txt_carrot!!
        val price = v.txt_quantity!!
        val addtoCarButton = v.addToCart!!
        val image = v.img_crop!!
    }


}