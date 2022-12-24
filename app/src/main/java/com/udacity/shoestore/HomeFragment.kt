package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_home,container,false
        )
        binding.loginButton.setOnClickListener{ view:View ->
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_welcomeFragment)
        }
        binding.newLoginButton.setOnClickListener{ view:View ->
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_welcomeFragment)
        }
//        or
//        binding.loginButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_welcomeFragment))
        return  binding.root
    }


}