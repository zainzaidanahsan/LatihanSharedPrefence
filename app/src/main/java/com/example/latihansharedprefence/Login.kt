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
import com.example.latihansharedprefence.databinding.FragmentLoginBinding
import com.example.latihansharedprefence.databinding.FragmentRegisterBinding

class Login : Fragment() {
lateinit var binding: FragmentLoginBinding
lateinit var sharedPref : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)

        binding.txtGapunyaAkun.setOnClickListener(){
            Navigation.findNavController(requireView()).navigate(R.id.action_login_to_register)
        }
        binding.btnLogin.setOnClickListener{
            checkData()
        }
    }
    fun checkData(){
        if((binding.usernameLogin.text.toString() == sharedPref.getString("username","")) && (binding.passwordLogin.text.toString() == sharedPref.getString("password",""))){
            Navigation.findNavController(requireView()).navigate(R.id.action_login_to_home2)
        }else if (binding.usernameLogin.text.toString().isEmpty() && binding.passwordLogin.text.toString().isEmpty()){
            Toast.makeText(context, "Isi semua data dengan benar", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "Username/Password Salah!", Toast.LENGTH_LONG).show()
        }
    }

}