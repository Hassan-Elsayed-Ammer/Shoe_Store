package com.hassan.elsayed.ammer.shoe_store.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.hassan.elsayed.ammer.shoe_store.R
import com.hassan.elsayed.ammer.shoe_store.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.btnLogin.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }

}