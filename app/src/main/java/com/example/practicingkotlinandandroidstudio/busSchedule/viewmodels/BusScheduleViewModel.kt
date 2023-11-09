package com.example.practicingkotlinandandroidstudio.busSchedule.viewmodels

import androidx.lifecycle.ViewModel
import com.example.practicingkotlinandandroidstudio.busSchedule.database.Schedule
import com.example.practicingkotlinandandroidstudio.busSchedule.database.ScheduleDao

class BusScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel() {

    fun fullSchedule(): List<Schedule> = scheduleDao.getAll()

    fun scheduleForStopName(name: String): List<Schedule> = scheduleDao.getByStopName(name)
}