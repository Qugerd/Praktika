package com.example.praktika

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class CartFragment : Fragment(R.layout.cart_fragment) {

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Toolbar>(R.id.toolbar).setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        view.findViewById<TextView>(R.id.emptyText).visibility = View.VISIBLE

        view.findViewById<MaterialButton>(R.id.buyButton).text =
            "Заказать за 0 ₽"
    }
}