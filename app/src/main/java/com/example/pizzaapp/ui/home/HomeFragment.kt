package com.example.pizzaapp.ui.home

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.pizzaapp.R
import com.example.pizzaapp.`object`.AppInstance
import com.example.pizzaapp.adapter.CategoriesPagerAdapter
import com.example.pizzaapp.databinding.FragmentHomeBinding
import com.example.pizzaapp.domian.cartListener
import com.example.pizzaapp.ui.base.BaseActivity
import com.example.pizzaapp.ui.base.BaseFragment
import com.example.pizzaapp.ui.burger.BurgerFragment
import com.example.pizzaapp.ui.drinks.DrinkFragment
import com.example.pizzaapp.ui.pizza.PizzaFragment
import com.example.pizzaapp.util.navigate
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment  : BaseFragment() , cartListener {


    lateinit var binding: FragmentHomeBinding
    var selectedTab = -1
    var tabPosition: Int = 0
    val imageList = ArrayList<SlideModel>() // Create image list


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        setPagerAapter()

        return binding.root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var tab: TabLayout.Tab? = binding.tabLayout.getTabAt(0)
        val view = tab?.customView?.findViewById<TextView>(R.id.title)
        view?.setTextSize(24f)
        view?.setTextColor(Color.parseColor(getString(R.color.blue_A900)))




        imageList.add(SlideModel(R.drawable.backgroundimage, "Pizza %50 OFF", ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.backgroundimage, "Happy NewYear",ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.backgroundimage, "2021 Welcome",ScaleTypes.FIT))
        binding.imageSlider.setImageList(imageList)

        setListener()
    }

fun setListener(){
    binding.fab.setOnClickListener {
              navigate(R.id.action_homefragment_to_orderFragment)
    }


}

    fun setPagerAapter(){
       val adapter = CategoriesPagerAdapter(this,

            context = (activity as BaseActivity),
            manager = this.childFragmentManager)
        adapter.addFragment(PizzaFragment(), "PIZZA")
        adapter.addFragment(BurgerFragment(), "BURGER")
        adapter.addFragment(DrinkFragment(), "DRINKS")
        binding.pager.adapter = adapter
        binding.pager.offscreenPageLimit = 1
        binding.tabLayout.setupWithViewPager(binding.pager)
        for (i in 0 until binding.tabLayout.tabCount) {
            val view = (binding.pager.adapter as CategoriesPagerAdapter).getTabView(i)
            binding.tabLayout.getTabAt(i)?.setCustomView(view)
        }
        binding.pager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            @SuppressLint("MissingSuperCall")
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                selectedTab = position

            }


        })
        if (selectedTab >= 0 && selectedTab <= binding.pager.adapter?.count ?: 0) {
            binding.pager?.setCurrentItem(selectedTab, true)
        }
        binding.tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            @SuppressLint("ResourceType")
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val view = tab?.customView?.findViewById<TextView>(R.id.title)
                view?.setTextSize(16f)
                view?.setTextColor(Color.parseColor(getString(R.color.lightGrey)))
            }

            @SuppressLint("ResourceType")
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val view = tab?.customView?.findViewById<TextView>(R.id.title)
                view?.setTextSize(24f)
                view?.setTextColor(Color.parseColor(getString(R.color.blue_A900)))
            }


        })



    }

    override fun onCartUpdated(cart: String) {
        Log.d("#ok", "working : $cart")
        binding.textcounter.setText("${AppInstance.instance.cartProducts.size}")


    }


}




