package com.hassan.elsayed.ammer.shoe_store.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.hassan.elsayed.ammer.shoe_store.R
import com.hassan.elsayed.ammer.shoe_store.databinding.FragmentDetailsBinding
import com.hassan.elsayed.ammer.shoe_store.databinding.ItemShoeBinding
import com.hassan.elsayed.ammer.shoe_store.model.Shoe
import com.hassan.elsayed.ammer.shoe_store.ui.MainActivityViewModel

class DetailsFragment : Fragment() {


    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        binding.btnSave.setOnClickListener {
            addData()
            goToListFragment()
        }

        binding.btnCancel.setOnClickListener {
            goToListFragment()
        }
        return binding.root
    }

    private fun goToListFragment() {
        val action = DetailsFragmentDirections.actionDetailsFragmentToShoesListFragment()
        findNavController().navigate(action)
    }


    private fun addData() {
        val shoeName = binding.etShoeName.text.toString()
        val shoeSize = binding.etSize.text.toString()
        val shoeCompany = binding.etCompany.text.toString()
        val shoeDescription = binding.etDescription.text.toString()
        val shoe = Shoe(shoeName, shoeSize, shoeCompany, shoeDescription)
        viewModel.addShoe(shoe)
    }

}