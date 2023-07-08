package com.example.practicingkotlinandandroidstudio.Dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicingkotlinandandroidstudio.Affirmations.adapter.ItemAdapter
import com.example.practicingkotlinandandroidstudio.Dogglers.const.Layout
import com.example.practicingkotlinandandroidstudio.Dogglers.model.Dog
import com.example.practicingkotlinandandroidstudio.R


/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int,

    ) : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {
    private val dogs: List<Dog> = listOf()

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        val imageView: ImageView = view!!.findViewById(R.id.dog_image)
        val nameTextView: TextView = view!!.findViewById(R.id.dog_name)
        val ageTextView: TextView = view!!.findViewById(R.id.dog_age)
        val hobbiesTextView: TextView = view!!.findViewById(R.id.dog_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {

        if (layout == Layout.GRID) {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_dogglers_grid_list_item, parent, false)
        } else {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_dogglers_vertical_horizontal_list_item, parent, false)
        }

        return DogCardViewHolder(parent.rootView)
    }

    override fun getItemCount(): Int = dogs.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val item = dogs[position]
        holder.imageView.setImageResource(item.imageResourceId)
        holder.nameTextView.text = context!!.resources.getString(item.name.toInt())

        val resources = context?.resources
        holder.ageTextView.text = resources?.getString(R.string.dog_age)
        holder.hobbiesTextView.text = resources?.getString(R.string.dog_hobbies)
    }
}

