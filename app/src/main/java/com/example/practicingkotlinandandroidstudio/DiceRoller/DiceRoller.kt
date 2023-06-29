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
        val dice = Dice1(6)
        val diceRoll = dice.roll()
        val drawableResource1 = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.imageViewDice1.setImageResource(drawableResource1)
        binding.imageViewDice1.contentDescription = diceRoll.toString()
    }

    private fun rollDice2() {
        val dice = Dice2(6)
        val diceRoll = dice.roll()
        val drawableResource2 = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.imageViewDice2.setImageResource(drawableResource2)
        binding.imageViewDice2.contentDescription = diceRoll.toString()
    }

    class Dice1(private val numSides1: Int) {
        fun roll(): Int {
            return (1..numSides1).random()
        }
    }

    class Dice2(private val numSides2: Int) {
        fun roll(): Int {
            return (1..numSides2).random()
        }
    }

}

