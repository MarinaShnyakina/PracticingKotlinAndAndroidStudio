package com.example.practicingkotlinandandroidstudio.Affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicingkotlinandandroidstudio.Affirmations.adapter.ItemAdapter
import com.example.practicingkotlinandandroidstudio.Affirmations.data.Datasource
import com.example.practicingkotlinandandroidstudio.databinding.ActivityAffirmationsBinding

class MainClassAffirmations : AppCompatActivity() {
    lateinit var binding: ActivityAffirmationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAffirmationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataset = Datasource().loadAffirmations()
        binding.recyclerView.adapter = ItemAdapter(this, myDataset)
        binding.recyclerView.setHasFixedSize(true)
    }
}