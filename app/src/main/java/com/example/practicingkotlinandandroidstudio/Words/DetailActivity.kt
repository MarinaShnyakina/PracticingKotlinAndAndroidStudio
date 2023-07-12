package com.example.practicingkotlinandandroidstudio.Words

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicingkotlinandandroidstudio.R
import com.example.practicingkotlinandandroidstudio.databinding.ActivityWordsDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWordsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWordsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val letterId = "A"

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WordAdapter(letterId, this)

        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        title = getString(R.string.detail_prefix) + " " + letterId

    }
}