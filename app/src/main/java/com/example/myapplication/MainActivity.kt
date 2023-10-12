package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }


    private fun init(x: Int,y: Int,z: Int){
        binding.gyroscopeX.text = x.toString()
        binding.gyroscopeY.text = y.toString()
        binding.gyroscopeZ.text = z.toString()
    }
}