package com.example.practicingkotlinandandroidstudio.Dogglers.model

import android.content.res.Resources
import androidx.annotation.DrawableRes


/**
 * A data class to represent the information presented in the dog card
 */

class Dog (
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val age: String,
    val hobbies: String
        )