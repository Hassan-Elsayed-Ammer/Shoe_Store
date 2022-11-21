package com.hassan.elsayed.ammer.shoe_store.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.hassan.elsayed.ammer.shoe_store.R
import com.hassan.elsayed.ammer.shoe_store.databinding.FragmentShoesListBinding
import com.hassan.elsayed.ammer.shoe_store.databinding.ItemShoeBinding
import com.hassan.elsayed.ammer.shoe_store.model.Shoe
import com.hassan.elsayed.ammer.shoe_store.ui.MainActivityViewModel

class ShoesListFragment : Fragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()
    private lateinit var binding: FragmentShoesListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)

        viewModel.getShoes().observe(viewLifecycleOwner) { shoesList ->
            for (item in shoesList) {
                addShowToList(container, item)
            }
        }


        binding.btnAdd.setOnClickListener {
            goToDetailsFragment()
        }

        setHasOptionsMenu(true)
        return binding.root
    }


    private fun goToLoginFragment() {
        val action = ShoesListFragmentDirections.actionShoesListFragmentToLoginFragment()
        findNavController().navigate(action)
    }

    private fun goToDetailsFragment() {
        val action = ShoesListFragmentDirections.actionShoesListFragmentToDetailsFragment()
        findNavController().navigate(action)
    }


    private fun addShowToList(  container: ViewGroup?, shoe: Shoe ) {
        val bindingItemShoe: ItemShoeBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_shoe, container, false)
        bindingItemShoe.shoe = shoe
        binding.itemsList.addView(bindingItemShoe.root)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btn_logout -> {
                goToLoginFragment()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}