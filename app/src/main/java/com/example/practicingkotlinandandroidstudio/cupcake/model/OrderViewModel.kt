package com.example.practicingkotlinandandroidstudio.cupcake.model

import androidx.lifecycle.*
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

// Цена за один кекс
private const val PRICE_PER_CUPCAKE = 2.00

// Доп плата за доставку в тот же день
private const val PRICE_FOR_SAME_DAY_PICKUP = 3.00

class OrderViewModel : ViewModel() {
    // Кол-во кексов в заказе
    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> = _quantity

    // Вкус кекса в заказе
    private val _flavor = MutableLiveData<String>()
    val flavor: LiveData<String> = _flavor

    // Возможные варианты дат
    val dateOptions: List<String> = getPickupOptions()

    // Дата заказа
    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    // Цена на данный момент заказа
    private val _price = MutableLiveData<Double>()
    val price: LiveData<String> = _price.map {
        // Форматирование цены в местной валюте и возврат цены в Строке
        NumberFormat.getCurrencyInstance().format(it)
    }

    init {
        // Установка начального значения заказа
        resetOrder()
    }

    // Указание кексов для заказа
    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
        updatePrice()
    }

    // Указать вкус кекса, можно выбрать только один вкус
    fun setFlavor(desiredFlavor: String) {

        _flavor.value = desiredFlavor
    }

    // Указание даты доставки заказа
    fun setData(pickupData: String) {
        _date.value = pickupData
        updatePrice()
    }

    /* Возвращает значение true, если аромат еще не был выбран для заказа.
    В противном случае возвращает значение false.
    * */
    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }

    /* Сбрасывает заказ, используя начальные значения по умолчанию для количества,
    вкуса, даты и цены.
    * */
    fun resetOrder() {
        _quantity.value = 0
        _flavor.value = ""
        _date.value = dateOptions[0]
        _price.value = 0.0
    }

    // Обновлет цену на основе сведений о заказе
    private fun updatePrice() {
        var calculatePrice = (quantity.value ?: 0) * PRICE_PER_CUPCAKE
        // Если пользователь выбрал первый вариант (сегодня) для самовывоза, добавляется доп плата
        if (dateOptions[0] == _date.value) {
            calculatePrice += PRICE_FOR_SAME_DAY_PICKUP
        }
        _price.value = calculatePrice
    }

    /* Возвращает список параметров даты, начинающийся с текущей даты
    и следующих 3 дат.
    * */
    private fun getPickupOptions(): List<String> {
        val options = mutableListOf<String>()
        val formater = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        // Создает список дат, начиная с текущей даты и следующих трех дат
        repeat(4) {
            options.add(formater.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }
}