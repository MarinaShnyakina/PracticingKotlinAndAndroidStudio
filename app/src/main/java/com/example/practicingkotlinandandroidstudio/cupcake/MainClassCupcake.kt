package com.example.practicingkotlinandandroidstudio.cupcake

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.practicingkotlinandandroidstudio.R

/**
 * Activity for cupcake order flow.
 */
class MainClassCupcake : AppCompatActivity(R.layout.main_activity_cupcake) {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Извлечение NavController из фрагмента узла Nav
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Настройка панели действия для использования с NavController
        setupActionBarWithNavController(navController)
    }

    // активация кнопки Up
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}

