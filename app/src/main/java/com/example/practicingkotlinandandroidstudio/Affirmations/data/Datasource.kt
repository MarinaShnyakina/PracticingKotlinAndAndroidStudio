package com.example.practicingkotlinandandroidstudio.Affirmations.data

import com.example.practicingkotlinandandroidstudio.Affirmations.model.Affirmation
import com.example.practicingkotlinandandroidstudio.R

class Datasource {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation_1),
            Affirmation(R.string.affirmation_2),
            Affirmation(R.string.affirmation_3),
            Affirmation(R.string.affirmation_4),
            Affirmation(R.string.affirmation_5),
            Affirmation(R.string.affirmation_6),
            Affirmation(R.string.affirmation_7),
            Affirmation(R.string.affirmation_8),
            Affirmation(R.string.affirmation_9),
            Affirmation(R.string.affirmation_10),
        )
    }
}