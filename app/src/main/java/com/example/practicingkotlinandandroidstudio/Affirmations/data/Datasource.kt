package com.example.practicingkotlinandandroidstudio.Affirmations.data

import com.example.practicingkotlinandandroidstudio.Affirmations.model.Affirmation
import com.example.practicingkotlinandandroidstudio.R

class Datasource {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation_1, R.drawable.image_affirmation_1),
            Affirmation(R.string.affirmation_2, R.drawable.image_affirmation_2),
            Affirmation(R.string.affirmation_3, R.drawable.image_affirmation_3),
            Affirmation(R.string.affirmation_4, R.drawable.image_affirmation_4),
            Affirmation(R.string.affirmation_5, R.drawable.image_affirmation_5),
            Affirmation(R.string.affirmation_6, R.drawable.image_affirmation_6),
            Affirmation(R.string.affirmation_7, R.drawable.image_affirmation_7),
            Affirmation(R.string.affirmation_8, R.drawable.image_affirmation_8),
            Affirmation(R.string.affirmation_9, R.drawable.image_affirmation_9),
            Affirmation(R.string.affirmation_10, R.drawable.image_affirmation_10),
        )
    }
}