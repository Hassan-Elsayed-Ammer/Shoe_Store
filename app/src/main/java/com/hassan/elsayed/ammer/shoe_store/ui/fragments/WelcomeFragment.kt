package com.hassan.elsayed.ammer.shoe_store.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hassan.elsayed.ammer.shoe_store.R
import com.hassan.elsayed.ammer.shoe_store.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {


    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        binding.btnWelcome.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }

}