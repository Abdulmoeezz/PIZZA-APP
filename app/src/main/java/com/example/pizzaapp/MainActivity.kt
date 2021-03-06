package com.example.pizzaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.pizzaapp.databinding.ActivityMainBinding
import com.example.pizzaapp.ui.base.BaseActivity

class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainActivityBinding = binding

    }

    companion object {
        lateinit var mainActivityBinding: ActivityMainBinding
    }
}