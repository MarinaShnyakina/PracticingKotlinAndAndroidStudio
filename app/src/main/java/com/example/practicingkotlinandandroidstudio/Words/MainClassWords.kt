package com.example.practicingkotlinandandroidstudio.Words

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicingkotlinandandroidstudio.R
import com.example.practicingkotlinandandroidstudio.databinding.ActivityWordsMainBinding


class MainClassWords : AppCompatActivity() {
    private lateinit var binding: ActivityWordsMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWordsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

