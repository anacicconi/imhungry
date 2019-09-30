package com.example.android.imhungry


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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
            food = Food(getFitFoods().random())
        }

        if (args.foodType === "fat") {
            food = Food(getFatFoods().random())
        }

        binding.food = food
        binding.foodImg.setImageDrawable(ContextCompat.getDrawable(context!!, getFoodImages(food.name)))

        return binding.root
    }

    private fun getFitFoods(): List<String> {
        return listOf("Banana", "Almonds", "Apple", "Yogurt")
    }

    private fun getFatFoods(): List<String> {
        return listOf("Chocolate", "Croissant", "Cheese cake", "Ice cream")
    }

    private fun getFoodImages(foodName: String): Int {
        val map = mapOf(
            "Banana" to R.drawable.banana,
            "Almonds" to R.drawable.almond,
            "Apple" to R.drawable.apple,
            "Yogurt" to R.drawable.yogurt,
            "Chocolate" to R.drawable.chocolate,
            "Croissant" to R.drawable.croissant,
            "Cheese cake" to R.drawable.cheesecake,
            "Ice cream" to R.drawable.icecream
        )

        var finalFoodImg: Int = R.drawable.banana
        val foodImg = map[foodName]

        if(foodImg !== null) {
            finalFoodImg = foodImg
        }

        return finalFoodImg
    }
}
