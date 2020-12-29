package com.example.pizzaapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.pizzaapp.R
import com.example.pizzaapp.domian.cartListener
import com.example.pizzaapp.ui.burger.BurgerFragment
import com.example.pizzaapp.ui.drinks.DrinkFragment
import com.example.pizzaapp.ui.pizza.PizzaFragment
import com.google.android.material.tabs.TabLayout

class CategoriesPagerAdapter(cartListener: cartListener,context: Context, manager: FragmentManager) : FragmentStatePagerAdapter(manager) {


    var context: Context
    var cartListenerr: cartListener
    var category = ArrayList<String>()
    var Fragment = ArrayList<Fragment>()


    init {
        this.context = context
        this.cartListenerr = cartListener

    }


    override fun getItem(position: Int): Fragment {
        when (position) {
            1 -> PizzaFragment.newInstance(cartListenerr)
            2 -> BurgerFragment.newInstance(cartListenerr)
            3 -> DrinkFragment.newInstance(cartListenerr)
            else -> { // Note the block
                DrinkFragment.newInstance(cartListenerr)
            }
        }
        return Fragment[position]
    }

    override fun getCount(): Int {
        return Fragment.size
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return category[position]
    }

    fun addFragment(fragment: Fragment , title:String){
        Fragment.add(fragment)
        category.add(title)
    }

    fun getTabView(position: Int): View {
        val v = LayoutInflater.from(context).inflate(R.layout.item_tablayout, null) as View
        val title = v.findViewById<TextView>(R.id.title)
        title.setText(this.category[position])
        return v



    }



}