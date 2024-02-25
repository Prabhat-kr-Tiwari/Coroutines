package com.example.coroutine

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


private val scope = CoroutineScope(Dispatchers.Default + CoroutineName("S100"))

fun main() {

    scope.launch(Dispatchers.IO) {
        println("c1 --")

        launch(CoroutineName("Inner100")) {
            println("c2 -- ${coroutineContext.get(CoroutineName.Key)}")

            launch {
                println("c3 -- ${coroutineContext.get(CoroutineName.Key)}")
            }
        }
    }

    Thread.sleep(1000)
    onDestroy()
}

private fun onDestroy(){
    println("cancelling scope")
    scope.cancel()
}