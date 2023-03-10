package com.example.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMenyu.setOnClickListener{
            val intent = Intent(this, Menyu::class.java)
            startActivity(intent)
        }
        binding.btnTaomQosh.setOnClickListener{
            val intent = Intent(this, TaomQoshish::class.java)
            startActivity(intent)
        }
    }
}