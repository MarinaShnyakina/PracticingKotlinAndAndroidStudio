package com.example.practicingkotlinandandroidstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.practicingkotlinandandroidstudio.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loggin()
        division()
    }
}

private fun division() {
    val numerator = 60
    var denominator = 4

    thread(start = true) {
        repeat(4) {
            Thread.sleep(3000)
            Log.v(TAG, "${numerator / denominator}")
                denominator--
        }
    }
}

private const val TAG = "MainActivity"
fun loggin() {
    Log.e(TAG, "ERROR: cерьезная ошибка, сбой")
    Log.w(TAG, "WARN: предупреждение о возможности серьезной ошибки")
    Log.i(TAG, "INFO: представление технической информации, например, успешное выполнение операции")
    Log.d(TAG, "DEBUG: представление технической информации, полезной для отладки")
    Log.v(TAG, "VERBOSE: более подробный, чем DEBUG")
}