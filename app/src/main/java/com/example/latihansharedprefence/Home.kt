package com.example.latihansharedprefence

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.latihansharedprefence.databinding.FragmentHomeBinding
import com.example.latihansharedprefence.databinding.FragmentLoginBinding

class Home : Fragment() {
lateinit var binding: FragmentHomeBinding
lateinit var sharePref: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharePref = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        binding.textHalo.text = "Halo,  " + sharePref.getString("fullname", "null")
        binding.imgLogout.setOnClickListener{
        var logOut = sharePref.edit()
            logOut.clear()
            logOut.apply()
            Navigation.findNavController(requireView()).navigate(R.id.action_home2_to_login)
        }
    }

}