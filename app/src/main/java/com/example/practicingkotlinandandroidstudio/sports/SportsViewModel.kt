package com.example.practicingkotlinandandroidstudio.sports

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practicingkotlinandandroidstudio.sports.data.SportsData
import com.example.practicingkotlinandandroidstudio.sports.model.Sport

class SportsViewModel : ViewModel() {

    // хранится текущий вид спорта выбранный пользователем
    private var _currentSport: MutableLiveData<Sport> = MutableLiveData<Sport>()
    val currentSport: LiveData<Sport>
        get() = _currentSport

    // содержит список спортивных данных
    private var _sportsData: ArrayList<Sport> = ArrayList()
    val sportsData: ArrayList<Sport>
        get() = _sportsData

    init {
        // Инициализированы спортивные данные
        _sportsData = SportsData.getSportsData()
        _currentSport.value = _sportsData[0]
    }

    fun updateCurrentSport(sport: Sport) {
        _currentSport.value = sport
    }
}