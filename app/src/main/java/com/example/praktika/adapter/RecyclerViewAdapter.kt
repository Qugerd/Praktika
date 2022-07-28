package com.example.praktika.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.praktika.R
import com.example.praktika.model.Product
import com.google.android.material.button.MaterialButton


class RecyclerViewAdapter(private val fragment: Fragment) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data: MutableList<Product> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FoodCardViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.food_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FoodCardViewHolder).bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Product>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class FoodCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val foodTagOne = itemView.findViewById<ImageView>(R.id.foodTagOne)
        private val foodTagTwo = itemView.findViewById<ImageView>(R.id.foodTagTwo)
        private val foodName = itemView.findViewById<TextView>(R.id.foodName)
        private val foodWeight = itemView.findViewById<TextView>(R.id.foodWeight)
        private val foodButton = itemView.findViewById<MaterialButton>(R.id.foodButton)
        private val minusButton = itemView.findViewById<MaterialButton>(R.id.minusButton)
        private val counter = itemView.findViewById<TextView>(R.id.counter)
        private val plusButton = itemView.findViewById<MaterialButton>(R.id.plusButton)

        fun bind(card: Product) {
            foodName.text = card.name
            foodWeight.text = card.measure.toString().plus(" ").plus(card.measureUnit)
            foodButton.text = card.priceCurrent.toString().plus(" ₽")
            foodTagOne.visibility = View.GONE
            foodTagTwo.visibility = View.GONE
            foodButton.visibility = View.VISIBLE
            minusButton.visibility = View.GONE
            counter.visibility = View.GONE
            plusButton.visibility = View.GONE
        }
    }
}