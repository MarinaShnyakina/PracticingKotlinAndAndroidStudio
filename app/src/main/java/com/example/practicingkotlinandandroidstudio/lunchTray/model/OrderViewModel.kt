package com.example.practicingkotlinandandroidstudio.lunchTray.model

import androidx.lifecycle.*
import java.text.NumberFormat
import com.example.practicingkotlinandandroidstudio.lunchTray.data.DataSource

class OrderViewModel : ViewModel() {

    // Карта пунктов прейскуранта
    val menuItems = DataSource.menuItems

    // Значения по умолчанию для цен на товары
    private var previousEntreePrice = 0.0
    private var previousSidePrice = 0.0
    private var previousAccompanimentPrice = 0.0

    // Налоговая ставка по умолчанию
    private val taxRate = 0.08

    // Основное блюдо для заказа
    private val _entree = MutableLiveData<MenuItem?>()
    val entree: LiveData<MenuItem?> = _entree

    // Гарнир для заказа
    private val _side = MutableLiveData<MenuItem?>()
    val side: LiveData<MenuItem?> = _side

    // Дополнение заказа
    private val _accompaniment = MutableLiveData<MenuItem?>()
    val accompaniment: LiveData<MenuItem?> = _accompaniment

    // Промежуточный итог по заказу
    private val _subtotal = MutableLiveData(0.0)
    val subtotal: LiveData<String> = _subtotal.map() {
        NumberFormat.getCurrencyInstance().format(it)
    }

    // Общая стоимость заказа
    private val _total = MutableLiveData(0.0)
    val total: LiveData<String> = _total.map() {
        NumberFormat.getCurrencyInstance().format(it)
    }

    // Налог за заказ
    private val _tax = MutableLiveData(0.0)
    val tax: LiveData<String> = _tax.map() {
        NumberFormat.getCurrencyInstance().format(it)
    }

    /**
     * Укажите основное блюдо для заказа.
     */
    fun setEntree(entree: String) {
        _entree.value?.run {
            previousEntreePrice = price
        }
        if (_subtotal.value != null) {
            _subtotal.value = _subtotal.value!! - previousEntreePrice
        }
        _entree.value = menuItems[entree]
        updateSubtotal(_entree.value!!.price)
    }

    /**
     * Установите гарнир для заказа.
     */
    fun setSide(side: String) {
        _side.value?.run {
            previousSidePrice = price
        }
        if (_subtotal.value != null) {
            _subtotal.value = _subtotal.value!! - previousSidePrice
        }
        _side.value = menuItems[side]
        updateSubtotal(_side.value!!.price)
    }

    /**
     * Установите дополнение для заказа.
     */
    fun setAccompaniment(accompaniment: String) {
        _accompaniment.value?.run {
            previousAccompanimentPrice = price
        }
        if (_subtotal.value != null) {
            _subtotal.value = _subtotal.value!! - previousAccompanimentPrice
        }
        _accompaniment.value = menuItems[accompaniment]
        updateSubtotal(_accompaniment.value!!.price)
    }

    /**
     * Обновите промежуточное итоговое значение.
     */
    private fun updateSubtotal(itemPrice: Double) {
        _subtotal.value = (_subtotal.value ?: 0.0) + itemPrice
        calculateTaxAndTotal()
    }

    /**
     * Рассчитайте налог и обновите итоговую сумму.
     */
    fun calculateTaxAndTotal() {
        val subTotal = _subtotal.value ?: 0.0
        _tax.value = subTotal * taxRate
        _total.value = subTotal + _tax.value!!
    }

    /**
     * Сбросьте все значения, относящиеся к заказу.
     */
    fun resetOrder() {
        previousSidePrice = 0.0
        previousEntreePrice = 0.0
        previousAccompanimentPrice = 0.0
        _tax.value = 0.0
        _total.value = 0.0
        _subtotal.value = 0.0
        _side.value = null
        _accompaniment.value = null
        _entree.value = null

    }
}