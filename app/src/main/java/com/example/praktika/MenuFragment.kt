package com.example.praktika

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.praktika.adapter.ViewPagerAdapter
import com.example.praktika.model.Category
import com.example.praktika.model.Tag
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MenuFragment : Fragment(R.layout.menu_fragment) {

    private val categoriesJsonPath = "Categories.json"
    private val categories: MutableList<Category> = mutableListOf()

    private val tagsJsonPath = "Tags.json"
    private val tags: MutableList<Tag> = mutableListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fetchJSON = FetchJSON(requireContext())
        categories.addAll(fetchJSON.parseCategories(categoriesJsonPath))
        tags.addAll(fetchJSON.parseTags(tagsJsonPath))

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        val pager = view.findViewById<ViewPager2>(R.id.viewPager)

        val adapter = ViewPagerAdapter(this)
        adapter.setData(categories)
        pager.adapter = adapter

        TabLayoutMediator(tabLayout, pager) { tab, position ->
            tab.text = categories[position].name
        }.attach()

        view.findViewById<FloatingActionButton>(R.id.cartToolbar).setOnClickListener{
            findNavController().navigate(R.id.action_menuFragment_to_cartFragment)
        }
    }
}