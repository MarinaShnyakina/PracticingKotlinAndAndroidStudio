package com.example.practicingkotlinandandroidstudio.TipTime

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
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
        binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(
                view,
                keyCode
            )
        }
    }

    private fun calculateTip() {
        binding.apply {
            val stringInTextField = costOfServiceEditText.text.toString()
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

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}