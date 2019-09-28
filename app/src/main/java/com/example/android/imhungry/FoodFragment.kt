package com.example.android.imhungry


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
// import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.android.imhungry.databinding.FragmentFoodBinding

/**
 * A simple [Fragment] subclass.
 */
class FoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFoodBinding>(inflater, R.layout.fragment_food, container, false)

        val args = FoodFragmentArgs.fromBundle(arguments!!)
        //Toast.makeText(context, "String: ${args.foodType}", Toast.LENGTH_LONG).show()

        lateinit var food: Food
        if (args.foodType === "fit") {
            food = Food("Banana")
        }

        if (args.foodType === "fat") {
            food = Food("Chocolate")
        }

        binding.food = food

        return binding.root

        //TODO: bind image path (DataBindAdapter)
        //TODO: add logic to randomly display a food name if it's fit or fat
    }
}
