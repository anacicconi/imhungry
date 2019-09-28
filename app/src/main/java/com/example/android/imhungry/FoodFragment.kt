package com.example.android.imhungry


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * A simple [Fragment] subclass.
 */
class FoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // add logic to random a food name if it's fit or fat
        val args = FoodFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context, "String: ${args.foodType}", Toast.LENGTH_LONG).show()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false)
    }
}
