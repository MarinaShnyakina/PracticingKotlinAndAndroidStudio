package com.example.practicingkotlinandandroidstudio.lunchTray

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.NavController
import com.example.practicingkotlinandandroidstudio.databinding.ActivityLunchMainBinding
import com.example.practicingkotlinandandroidstudio.databinding.ActivityMainBinding

class MainClassLunchTray : AppCompatActivity() {

    // Экземпляр объекта привязки, соответствующий activity_main.xml макет,
    // когда иерархия представлений прикреплена к фрагменту.
    private lateinit var binding: ActivityLunchMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLunchMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: Извлеките NavController из фрагмента узла Nav
    }
}