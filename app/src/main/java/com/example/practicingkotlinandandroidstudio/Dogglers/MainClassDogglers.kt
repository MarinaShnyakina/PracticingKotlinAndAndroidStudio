package com.example.practicingkotlinandandroidstudio.Dogglers

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicingkotlinandandroidstudio.databinding.ActivityDogglersMainBinding
import com.example.practicingkotlinandandroidstudio.databinding.ActivityMainBinding

class MainClassDogglers : AppCompatActivity() {

    private lateinit var binding: ActivityDogglersMainBinding
    private lateinit var listIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setup view binding
        binding = ActivityDogglersMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Launch the VerticalListActivity on verticalBtn click
        binding.verticalButton.setOnClickListener { launchVertical() }

        // Launch the HorizontalListActivity on horizontalBtn click
        binding.horizontalButton.setOnClickListener { launchHorizontal() }

        // Launch the GridListActivity on gridBtn click
        binding.gridButton.setOnClickListener { launchGrid() }
    }

    private fun launchVertical() {
        listIntent = Intent(this, VerticalListActivity::class.java)
        startActivity(listIntent)
    }

    private fun launchHorizontal() {
        listIntent = Intent(this, HorizontalListActivity::class.java)
        startActivity(listIntent)
    }

    private fun launchGrid() {
        listIntent = Intent(this, GridListActivity::class.java)
        startActivity(listIntent)
    }
}