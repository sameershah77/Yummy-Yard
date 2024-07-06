package com.example.yummyyards.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummyyards.R
import com.example.yummyyards.databinding.FragmentCookBinding
import com.example.yummyyards.recyclerview.FoodItemRecyclerViewAdapter
import com.example.yummyyards.ViewModel.DishViewModel
import com.example.yummyyards.recyclerview.DishRecyclerViewAdapter

class CookFragment : Fragment() {
    private val dishViewModel: DishViewModel by viewModels()
    private lateinit var binding: FragmentCookBinding
    private lateinit var foodAdapter: FoodItemRecyclerViewAdapter
    private lateinit var dishAdapter: DishRecyclerViewAdapter
    private lateinit var foodItemArr: ArrayList<Pair<String, Int>>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCookBinding.inflate(inflater, container, false)
        val view = binding.root

        foodItemArr = arrayListOf()

        foodItemArr.add(Pair("Rice Item", R.drawable.food_pizza))
        foodItemArr.add(Pair("Indian", R.drawable.food_noodles))
        foodItemArr.add(Pair("Curreis", R.drawable.food_lollipop))
        foodItemArr.add(Pair("Soups", R.drawable.food_burger))
        foodItemArr.add(Pair("Desserts", R.drawable.food_lollipop))
        foodItemArr.add(Pair("Burger", R.drawable.food_lollipop))
        foodItemArr.add(Pair("Burger", R.drawable.food_pizza))
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.foodItemRecyclerview.layoutManager = layoutManager
        foodAdapter = FoodItemRecyclerViewAdapter(requireContext(), foodItemArr)
        binding.foodItemRecyclerview.adapter = foodAdapter



        dishAdapter = DishRecyclerViewAdapter(requireContext(), arrayListOf())
        binding.mainFoodRecyclerview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.mainFoodRecyclerview.adapter = dishAdapter

        // Observe dishes from ViewModel
        dishViewModel.dishes.observe(viewLifecycleOwner, Observer { dishes ->
            dishes?.let {
                // Update adapters with new data
                dishAdapter.setDishes(it)    // Assuming you have a method setDishes in DishRecyclerViewAdapter

                // Optionally, log each dish
                for (dish in it) {
                    Log.d("CookFragment", "Dish name: ${dish.dishName}, Image URL: ${dish.imageUrl}")
                }
            }
        })

        return view
    }
}
