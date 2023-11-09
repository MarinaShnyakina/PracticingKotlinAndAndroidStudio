package com.example.practicingkotlinandandroidstudio.busSchedule

import android.app.Application
import com.example.practicingkotlinandandroidstudio.busSchedule.database.AppDatabase

class BusScheduleApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}