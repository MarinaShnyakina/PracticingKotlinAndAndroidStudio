package com.example.practicingkotlinandandroidstudio.Dogglers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicingkotlinandandroidstudio.Dogglers.adapter.DogCardAdapter
import com.example.practicingkotlinandandroidstudio.Dogglers.const.Layout
import com.example.practicingkotlinandandroidstudio.databinding.ActivityDogglersGridListBinding

class GridListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDogglersGridListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogglersGridListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gridRecyclerView.adapter = DogCardAdapter(
            applicationContext,
            Layout.GRID
        )

        // Specify fixed size to improve performance
        binding.gridRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}