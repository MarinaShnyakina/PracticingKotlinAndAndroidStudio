package com.example.practicingkotlinandandroidstudio.sports.model

import com.example.practicingkotlinandandroidstudio.R

/**
 * Data model for each row of the RecyclerView
 */
data class Sport(
    val id: Int,
    val titleResourceId: Int,
    val subTitleResourceId: Int,
    val imageResourceId: Int,
    val sportsImageBanner: Int,
    val newsDetails: Int = R.string.sports_news_detail_text
)