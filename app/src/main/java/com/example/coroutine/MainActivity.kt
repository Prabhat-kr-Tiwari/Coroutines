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
            CoroutineScope(Dispatchers.Main).launch {
//                showMessage()
                val no=findBigPrime()
                Log.d(TAG, "onCreate: $no")
            }


        }
    }
    private suspend fun showMessage(){
        Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_SHORT).show()
//        findBigPrime()
    }

 /*   suspend fun findBigPrime(): BigInteger =
        BigInteger.probablePrime(4096, java.util.Random())*/

    suspend fun findBigPrime(): BigInteger = withContext(Dispatchers.Default){
        BigInteger.probablePrime(4096, java.util.Random())
    }

}