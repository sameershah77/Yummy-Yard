package com.example.yummyyards

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.yummyyards.databinding.ActivityMainBinding
import com.example.yummyyards.fragments.CookFragment
import com.example.yummyyards.fragments.FavouriteFragment
import com.example.yummyyards.fragments.ManualFragment
import com.example.yummyyards.fragments.PreferenceFragment
import com.example.yummyyards.fragments.SettingFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val itemId = item.itemId
            if (itemId == R.id.bottom_cook) {
                replaceFragment(CookFragment())
            } else if (itemId == R.id.bottom_manual) {
                replaceFragment(ManualFragment())
            } else if (itemId == R.id.bottom_setting) {
                replaceFragment(SettingFragment())
            } else if (itemId == R.id.bottom_preference) {
                replaceFragment(PreferenceFragment())
            } else {
                replaceFragment(FavouriteFragment())
            }
            true
        }
//        default fragment
        replaceFragment(CookFragment())


    }

    fun replaceFragment(fragment: Fragment) {
        val fragManager = supportFragmentManager
        val fragTransaction = fragManager.beginTransaction()
        fragTransaction.replace(R.id.frame_layout, fragment)
        fragTransaction.commit()
    }
}