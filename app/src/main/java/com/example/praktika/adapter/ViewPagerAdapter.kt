package com.example.praktika.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.praktika.FoodMenuFragment
import com.example.praktika.model.Category

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val categories: MutableList<Category> = mutableListOf()

    override fun createFragment(position: Int): Fragment {
        return FoodMenuFragment(categories[position].id)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    fun setData(data: List<Category>) {
        categories.addAll(data)
    }
}