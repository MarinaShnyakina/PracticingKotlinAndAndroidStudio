package com.example.practicingkotlinandandroidstudio.TipTime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicingkotlinandandroidstudio.R
import com.example.practicingkotlinandandroidstudio.databinding.ActivityTipTimeBinding

class TipTime : AppCompatActivity() {
    lateinit var binding: ActivityTipTimeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}