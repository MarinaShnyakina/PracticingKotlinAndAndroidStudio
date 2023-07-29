package com.example.cupcake

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.practicingkotlinandandroidstudio.cupcake.model.OrderViewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ViewModelTests {
    /* Чтобы указать, что объекты Live Data не должны вызывать основной поток,
    * нам нужно предоставить конкретное правило тестирования каждый раз,
    * когда мы тестируем объект LiveData.
    */
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun quantity_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.quantity.observeForever {  }
        viewModel.setQuantity(12)
        assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.price.observeForever {  }
        viewModel.setQuantity(12)
        assertEquals("$27.00", viewModel.price.value)
    }


}