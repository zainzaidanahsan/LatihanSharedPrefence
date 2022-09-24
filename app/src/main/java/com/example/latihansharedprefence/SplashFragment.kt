package com.example.latihansharedprefence

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.latihansharedprefence.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
lateinit var binding: FragmentSplashBinding
lateinit var sharedPref : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)

    Handler().postDelayed({
        if (sharedPref.getString("username","").equals("")){
            Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_login)
        }else{
            Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_home2)
        }
    },3000)

    }

}