package com.example.movies.presentation.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.movies.R
import com.example.movies.databinding.ActivityHomeBinding
import com.example.movies.presentation.ui.home.home.HomeFragment
import com.example.movies.presentation.ui.home.play.PlayFragment
import com.example.movies.presentation.ui.home.profile.ProfileFragment
import com.example.movies.presentation.ui.home.search.SearchFragment


class HomeActivity : AppCompatActivity(R.layout.activity_home) {

    private lateinit var navController: NavController
    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.frameLayout) as NavHostFragment
        navController = navHostFragment.navController
        setActivityView()
        setFragment(HomeFragment())
        binding.navBar.setOnItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.home -> HomeFragment()
                R.id.search -> SearchFragment()
                R.id.play -> PlayFragment()
                else -> {
                    ProfileFragment()
                }
            }
            setFragment(fragment)
            true
        }
    }

    private fun setActivityView() {
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }


}