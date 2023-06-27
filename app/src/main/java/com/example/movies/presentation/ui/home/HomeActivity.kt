package com.example.movies.presentation.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.movies.R
import com.example.movies.databinding.ActivityHomeBinding
import com.example.movies.presentation.ui.home.home.HomeFragment
import com.example.movies.presentation.ui.home.home.HomeFragmentDirections
import com.example.movies.presentation.ui.home.profile.ProfileFragment
import com.example.movies.presentation.ui.home.search.SearchFragment
import com.example.movies.presentation.ui.home.search.SearchFragmentDirections
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity : AppCompatActivity(R.layout.activity_home) {

    private lateinit var navController: NavController
    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setNavController()
        //setUpView()
        //setFragment(HomeFragment())

        //TODO("Rotar pantalla y ver que pasa con navegación en proceso")

    }

    private fun setActivityView() {
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        findViewById<BottomNavigationView>(R.id.nav_bar)
            .setupWithNavController(navController)
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }


    private fun setUpView() {

        /*binding.navBar.setupWithNavController(navController)
        binding.navBar.setOnItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.home -> {

                    HomeFragmentDirections.actionHomeFragmentToSearchFragment()
                }
                R.id.search -> {
                    SearchFragmentDirections.actionSearchFragmentToPlayFragment()
                }
                R.id.play -> {}
                else -> {}
            }
            //setFragment(fragment)
            true
        }*/
        /** navController.addOnDestinationChangedListener{controller,destination,_->
        //controller.navigate(destination.id)
        }*/
    }


}