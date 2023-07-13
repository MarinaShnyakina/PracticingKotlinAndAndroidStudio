package com.example.affirmation


import android.content.Context
import com.example.practicingkotlinandandroidstudio.Affirmations.adapter.ItemAdapter
import com.example.practicingkotlinandandroidstudio.Affirmations.model.Affirmation
import org.junit.Test
import com.example.practicingkotlinandandroidstudio.R
import org.junit.Assert.assertEquals
import org.mockito.Mockito.mock

class AffirmationsAdapterTests {

    private val context = mock(Context::class.java)

    @Test
    fun adapter_size() {
        val data = listOf(
            Affirmation(R.string.affirmation_1, R.drawable.image_affirmation_1),
            Affirmation(R.string.affirmation_2, R.drawable.image_affirmation_2)
        )

        val adapter = ItemAdapter(context, data)
        assertEquals("ItemAdapter is not the correct size", data.size, adapter.itemCount)
    }
}