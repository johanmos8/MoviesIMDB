package com.example.movies.presentation.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movies.R
import com.example.movies.databinding.FragmentLoginBinding
import com.example.movies.presentation.ui.home.HomeActivity


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentLoginBinding.inflate(inflater, container, false)
        _binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding?.signUpText?.setOnClickListener {
            navigateToSignUp()
        }
        _binding?.loginButton?.setOnClickListener {
            navigateToHome()
        }

    }

    private fun navigateToSignUp() {
        findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
    }

    private fun navigateToHome() {
        val intent = Intent(context, HomeActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}