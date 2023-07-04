package com.example.practicingkotlinandandroidstudio.TipTime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicingkotlinandandroidstudio.R
import com.example.practicingkotlinandandroidstudio.databinding.ActivityTipTimeBinding
import java.lang.Math.ceil
import java.text.NumberFormat

class TipTime : AppCompatActivity() {
    private lateinit var binding: ActivityTipTimeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        binding.apply {
            val stringInTextField = costOfService.text.toString()
            val cost = stringInTextField.toDoubleOrNull()
            if (cost == null) {
                tipResult.text = ""
                return
            }

            val tipPercentage = when (tipOptions.checkedRadioButtonId) {
                R.id.option_twenty_percent -> 0.20
                R.id.option_eighteen_percent -> 0.18
                else -> 0.15
            }

            var tip = tipPercentage * cost
            if (roundUpSwitch.isChecked) {
                tip = kotlin.math.ceil(tip)
            }

            val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
            tipResult.text = getString(R.string.tip_amount, formattedTip)

        }


    }
}