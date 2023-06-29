package com.example.practicingkotlinandandroidstudio.DiceRoller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.practicingkotlinandandroidstudio.R
import com.example.practicingkotlinandandroidstudio.databinding.ActivityDiceRollerBinding

class DiceRoller : AppCompatActivity() {
    lateinit var binding: ActivityDiceRollerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiceRollerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRoll.setOnClickListener {
            rollDice1()
            rollDice2()
        }
    }


    private fun rollDice1() {
        val dice1 = Dice1(6)
        val diceRoll = dice1.roll()
        binding.textViewDice1.text = diceRoll.toString()

    }

    private fun rollDice2() {
        val dice2 = Dice2(10)
        val diceRoll = dice2.roll()
        binding.textViewDice2.text = diceRoll.toString()
    }

    class Dice1(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    class Dice2(private val numSides2: Int) {
        fun roll(): Int {
            return (1..numSides2).random()
        }
    }

}

