package com.example.practicingkotlinandandroidstudio.debugging

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.practicingkotlinandandroidstudio.R

public val TAG = "MainClassDebugging"

class MainClassDebugging : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        division()
    }

    fun division() {
        val numerator = 60
        var denominator = 4
        repeat(4) {
            Log.v(TAG, "${numerator / denominator}")
            denominator--
        }
    }
}