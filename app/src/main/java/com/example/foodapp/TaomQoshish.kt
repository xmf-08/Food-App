package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodapp.databinding.ActivityMenyuBinding
import com.example.foodapp.databinding.ActivityTaomQoshishBinding
import com.example.foodapp.databinding.ItemBinding
import com.example.foodapp.databinding.ItemListBinding

class TaomQoshish : AppCompatActivity() {
    lateinit var binding: ActivityTaomQoshishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaomQoshishBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_taom_qoshish)

        MySharedPreferance.init(this)
        loadUi()
        binding.saqlaBtn?.setOnClickListener {
            var list = MySharedPreferance.catchList
            list.add(User(binding.edtTaomnomi?.text.toString(),
                binding.edtKeraklimahsulotlar?.text.toString(), binding.tartib?.text.toString()))
            loadData()
        }
    }

    private fun loadData() {
        var list = MySharedPreferance.catchList
        var str =""
        list.forEach {
            str += "${it.taomNomi} ${it.kerakli} ${it.tartib}\n\n\n"
        }
    }
    private fun loadUi(){
        var list = MySharedPreferance.catchList
        for (user in list) {
            var menyu = ActivityMenyuBinding.inflate(layoutInflater)
            var itemListBinding = ItemListBinding.inflate(layoutInflater)
            menyu.tvLiner.addView(itemListBinding.root)
            itemListBinding.tvName.text = user.taomNomi
        }
    }
}