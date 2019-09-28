package com.example.android.imhungry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.imhungry.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Without binding data
        // return inflater.inflate(R.layout.fragment_start, container, false)

        val binding = DataBindingUtil.inflate<FragmentStartBinding>(inflater, R.layout.fragment_start, container, false)

        binding.buttonFit.setOnClickListener { view: View ->
            // Without binding data
            // Navigation.createNavigateOnClickListener(R.id.action_startFragment_to_foodFragment)
            view.findNavController().navigate(StartFragmentDirections.actionStartFragmentToFoodFragment("fit"))
        }

        binding.buttonFat.setOnClickListener { view: View ->
            view.findNavController().navigate(StartFragmentDirections.actionStartFragmentToFoodFragment("fat"))
        }

        return binding.root
    }
}
