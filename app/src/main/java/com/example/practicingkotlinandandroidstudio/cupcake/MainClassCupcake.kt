package com.example.practicingkotlinandandroidstudio.cupcake

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.practicingkotlinandandroidstudio.R

/**
 * Activity for cupcake order flow.
 */
class MainClassCupcake : AppCompatActivity(R.layout.main_activity_cupcake) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Извлечение NavController из фрагмента узла Nav
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Настройка панели действия для использования с NavController
        setupActionBarWithNavController(navController)
    }
}

