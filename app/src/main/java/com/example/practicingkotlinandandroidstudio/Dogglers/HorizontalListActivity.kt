package com.example.practicingkotlinandandroidstudio.Dogglers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicingkotlinandandroidstudio.Dogglers.adapter.DogCardAdapter
import com.example.practicingkotlinandandroidstudio.Dogglers.const.Layout
import com.example.practicingkotlinandandroidstudio.databinding.ActivityDogglersHorizontalListBinding

class HorizontalListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDogglersHorizontalListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogglersHorizontalListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.horizontalRecyclerView.adapter = DogCardAdapter(
            applicationContext,
            Layout.HORIZONTAL
        )

        // Specify fixed size to improve performance
        binding.horizontalRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}