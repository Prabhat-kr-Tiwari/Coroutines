package com.example.coroutine

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutine.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigInteger
import java.net.URL

class MainActivity : AppCompatActivity() {
   lateinit var binding: ActivityMainBinding
    companion object{
        val TAG="PRABHAT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRunCode.setOnClickListener {


            //suspending call
         /*   CoroutineScope(Dispatchers.Main.immediate).launch {
                delay(3000)
                showMessage()
            }*/

            //block call

            Thread.sleep(3000)
            showMessage()
        }
    }
    private fun showMessage(){
        Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_SHORT).show()
    }

    suspend fun findBigPrime(): BigInteger =
        BigInteger.probablePrime(4096, java.util.Random())
}