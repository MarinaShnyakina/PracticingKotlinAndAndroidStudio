package com.example.practicingkotlinandandroidstudio.busSchedule.database

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

data class Schedule(
    @PrimaryKey val id:Int,
    @NotNull @ColumnInfo(name = "stop_name") val stopName: String,
    @NotNull @ColumnInfo(name = "arrive_time") val arriveTime: Int,
)
