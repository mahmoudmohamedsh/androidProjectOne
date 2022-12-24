package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.models.Shoe
import viewModels.AddShoeViewModel
import viewModels.ShoeViewModel


class AddShoeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding : FragmentAddShoeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_shoe,container,false)

        val viewModel:AddShoeViewModel = ViewModelProvider(this).get(AddShoeViewModel::class.java)

        var shoesViewModel : ShoeViewModel
        activity.let {
            shoesViewModel = ViewModelProvider(it!!).get(ShoeViewModel::class.java)
        }
        binding.myData = viewModel.shoe

        binding.cancelButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_addShoeFragment_to_shoeListFragment))

        binding.addButton.setOnClickListener{view:View ->

            shoesViewModel.addNewShoe(viewModel.shoe)
            for(i in shoesViewModel.shoesList){
                Log.i("list","${i.name}")
            }

            Navigation.findNavController(view).navigate(R.id.action_addShoeFragment_to_shoeListFragment)

        }


        return binding.root
    }




}