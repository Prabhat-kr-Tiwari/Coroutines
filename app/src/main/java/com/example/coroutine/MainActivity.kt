package com.example.coroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    companion object {
        val TAG = "PRABHAT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRunCode.setOnClickListener {


        }
    }


}