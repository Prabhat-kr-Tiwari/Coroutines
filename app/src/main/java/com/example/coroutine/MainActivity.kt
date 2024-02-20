package com.example.coroutine

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity : AppCompatActivity() {
    companion object{
        val TAG="PRABHAT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonLoadImage = findViewById<Button>(R.id.button_load_image)
        val imageView = findViewById<ImageView>(R.id.image)

        buttonLoadImage.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.d(TAG, "onCreate: Thread Name ${Thread.currentThread().name}")


                val url = URL("https://i.redd.it/bfc0pz8qdji61.jpg")
                val bitmap = BitmapFactory.decodeStream(url.openStream())
                withContext(Dispatchers.Main) {
                    Log.d(TAG, "onCreate: Thread Name ${Thread.currentThread().name}")

                    imageView.setImageBitmap(bitmap)
                }
            }

        }
    }
}