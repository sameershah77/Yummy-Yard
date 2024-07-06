package com.example.yummyyards.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yummyyards.R
import com.example.yummyyards.databinding.FragmentTimePickerBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class TimePickerBottomSheetDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentTimePickerBottomSheetDialogBinding
    private lateinit var onTimePickedListener: (String) -> Unit
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTimePickerBottomSheetDialogBinding.inflate(inflater, container, false)
        val view = binding.root
        showTimePicker()
        return view
    }
    private fun showTimePicker() {
        val timePicker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Appointment time")
            .build()

        timePicker.addOnPositiveButtonClickListener {
            val hour = timePicker.hour
            val minute = timePicker.minute
            val formattedTime = String.format("%02d:%02d", hour, minute)
            onTimePickedListener.invoke(formattedTime)
            dismiss()
        }

        timePicker.show(childFragmentManager, "timePicker")
    }

    fun setOnTimePickedListener(listener: (String) -> Unit) {
        onTimePickedListener = listener
    }
}