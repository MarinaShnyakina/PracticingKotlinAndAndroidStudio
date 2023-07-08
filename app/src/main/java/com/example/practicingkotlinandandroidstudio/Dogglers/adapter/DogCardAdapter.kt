package com.example.practicingkotlinandandroidstudio.Dogglers.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Initialize the data using the List found in data/DataSource

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // TODO: Declare and initialize all of the list item UI components
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.

        // TODO Inflate the layout

        // TODO: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        return DogCardViewHolder(null)
    }

    override fun getItemCount(): Int = 0 // TODO: return the size of the data set instead of 0
    // возвращает размер набора данных вместо 0

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // TODO: Получите данные по текущей позиции
        // TODO: Установите ресурс изображения для текущей собаки
        // TODO: Установите текст для текущего имени собаки
        // TODO: Установите текст для текущего возраста собаки
        val resources = context?.resources
        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
