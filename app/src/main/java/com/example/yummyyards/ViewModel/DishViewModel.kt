package com.example.yummyyards.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yummyyards.APIs.RetrofitInstance
import com.example.yummyyards.models.Dish
import kotlinx.coroutines.launch

class DishViewModel : ViewModel() {
    private val _dishes = MutableLiveData<List<Dish>>()
    val dishes: LiveData<List<Dish>> = _dishes

    init {
        fetchDishes()
    }

    private fun fetchDishes() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getDishes()
                _dishes.postValue(response)
                for (dish in response) {
                    Log.d("DishViewModel", "Dish name: ${dish.dishName}, Image URL: ${dish.imageUrl}")
                }
            } catch (e: Exception) {
                Log.e("DishViewModel", "Error fetching dishes", e)

            }
        }
    }
}
