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

    // Сторона для заказа
    private val _side = MutableLiveData<MenuItem?>()
    val side: LiveData<MenuItem?> = _side

    // Сопровождение заказа
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
        // TODO: если _entire.value не равно null, установите предыдущую цену основного блюда
        //  на текущую цену основного блюда.

        // TODO: если _subtotal.value не равно null, вычтите предыдущую цену основного блюда
        //  из текущего значения промежуточного итога. Это гарантирует, что мы берем плату только за выбранное в данный момент блюдо.

        // TODO: установите текущее значение entree для пункта прейскуранта, соответствующего переданной строке
        // TODO: обновите промежуточный итог, чтобы отразить цену выбранного основного блюда.
    }

    /**
     * Установите сторону для заказа.
     */
    fun setSide(side: String) {
        // TODO: если _side.value не равно null, установите предыдущую побочную цену на текущую побочную цену.

        // TODO: если _subtotal.value не равно null, вычтите предыдущую дополнительную цену из текущего значения
        //  промежуточного итога. Это гарантирует, что мы взимаем плату только за выбранную в данный момент сторону.

        // TODO: установите текущее побочное значение для пункта прейскуранта, соответствующего переданной строке
        // TODO: обновите промежуточный итог, чтобы отразить цену выбранной стороны.
    }

    /**
     * Установите сопровождение для заказа.
     */
    fun setAccompaniment(accompaniment: String) {
        // TODO: если _accompaniment.value не равно null, установите предыдущую цену аккомпанемента
        //  на текущую цену аккомпанемента.

        // TODO: если _accompaniment.value не равно null, вычтите предыдущую цену сопровождения из
        //  текущего промежуточного итогового значения. Это гарантирует, что мы берем плату только
        //  за выбранный в данный момент аккомпанемент.

        // TODO: установите текущее значение аккомпанемента в пункт меню, соответствующий переданной строке
        // TODO: обновите промежуточный итог, чтобы отразить цену выбранного сопровождения.
    }

    /**
     * Обновите промежуточное итоговое значение.
     */
    private fun updateSubtotal(itemPrice: Double) {
        // TODO: если _subtotal.value не равно null, обновите его,
        //  чтобы отразить цену недавно добавленного товара.
        //  В противном случае установите значение _subtotal.value равным цене товара.

        // TODO: рассчитайте налог и итоговую сумму
    }

    /**
     * Рассчитайте налог и обновите итоговую сумму.
     */
    fun calculateTaxAndTotal() {
        // TODO: установите _tax.value на основе промежуточного итога и налоговой ставки.
        // TODO: установите итоговую сумму на основе промежуточного итога и _tax.value.
    }

    /**
     * Сбросьте все значения, относящиеся к заказу.
     */
    fun resetOrder() {
        // TODO: Сбросить все значения, связанные с заказом

    }
}