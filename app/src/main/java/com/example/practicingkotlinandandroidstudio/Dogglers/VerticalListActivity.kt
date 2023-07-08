package com.example.practicingkotlinandandroidstudio.Dogglers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practicingkotlinandandroidstudio.Dogglers.adapter.DogCardAdapter
import com.example.practicingkotlinandandroidstudio.Dogglers.const.Layout
import com.example.practicingkotlinandandroidstudio.databinding.ActivityDogglersVerticalListBinding

class VerticalListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDogglersVerticalListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogglersVerticalListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.verticalRecyclerView.adapter = DogCardAdapter(
            applicationContext,
            Layout.VERTICAL
        )

        // Specify fixed size to improve performance
        binding.verticalRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}