package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.FragmentSingleItemBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.models.Shoe
import viewModels.ShoeViewModel


class ShoeListFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentShoeListBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,container,false)

        setHasOptionsMenu(true)
        var viewModel : ShoeViewModel
        activity.let {
             viewModel = ViewModelProvider(it!!).get(ShoeViewModel::class.java)
        }



        /*
        * inject the shoe list screen with the items
        *
        * */

        for(shoe in viewModel.shoesList){
            val itemBinding = FragmentSingleItemBinding.inflate(layoutInflater)
            itemBinding.myShoe = shoe
            binding.linearLayout.addView(itemBinding.root)
            Log.i("item","${shoe.name}")
        }

        // navigate to the add fragment
        binding.addButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_addShoeFragment))

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.main_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())||super.onOptionsItemSelected(item)
    }



}