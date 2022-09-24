package com.example.latihansharedprefence

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.latihansharedprefence.databinding.FragmentRegisterBinding
import com.example.latihansharedprefence.databinding.FragmentSplashBinding

class Register : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    lateinit var sharedPref: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)

        binding.btnReg.setOnClickListener() {
            if (binding.fullnameReg.text.toString().isEmpty() || binding.username.text.toString()
                    .isEmpty() || binding.password.text.toString()
                    .isEmpty() || binding.repeatPass.text.toString().isEmpty()
            ) {
                Toast.makeText(context, "Lengkapi Data Jangan Sampai Kosong!", Toast.LENGTH_LONG)
                    .show()
            } else if (binding.repeatPass.text.toString() != binding.password.text.toString()) {
                Toast.makeText(context, "Password Tidak Sesuai", Toast.LENGTH_LONG)
                    .show()
            }
            else{
                addData()
                Toast.makeText(context, "Registrasi Berhasil", Toast.LENGTH_LONG)
                    .show()
                Navigation.findNavController(requireView()).navigate(R.id.action_register_to_login)
            }
        }
    }

    fun addData(){
        var getFullname = binding.fullnameReg.text.toString()
        var getUsername = binding.username.text.toString()
        var getPass = binding.password.text.toString()

        var addData = sharedPref.edit()
        addData.putString("fullname", getFullname)
        addData.putString("username", getUsername)
        addData.putString("password", getPass)
        addData.apply()
    }
}