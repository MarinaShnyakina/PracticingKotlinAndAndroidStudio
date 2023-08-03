package com.example.practicingkotlinandandroidstudio.lunchTray.model

import java.text.NumberFormat

// Класс данных для пунктов прейскуранта

data class MenuItem(
    val name: String,
    val description: String,
    val price: Double,
    val type: Int
) {
    /**
     * Метод получения цены.
     * Включает форматирование.
     */
    fun getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(price)
}