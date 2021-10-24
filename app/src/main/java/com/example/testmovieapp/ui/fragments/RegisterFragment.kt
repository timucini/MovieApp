package com.example.testmovieapp.ui.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.testmovieapp.databinding.FragmentRegisterBinding
import com.example.testmovieapp.ui.viewmodels.AuthenticationViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class RegisterFragment: Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    @Inject lateinit var viewModel: AuthenticationViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            when {
                TextUtils.isEmpty(binding.etEmailRegister.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                        activity,
                        "Please enter Email",
                        Toast.LENGTH_LONG
                    ).show()
                }
                TextUtils.isEmpty(binding.etPassRegister.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                        activity,
                        "Please enter Password",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else -> {
                    val email: String = binding.etEmailRegister.text.toString().trim { it <= ' '}
                    val password: String = binding.etPassRegister.text.toString().trim { it <= ' '}

                    viewModel.registerToFireBase(email, password)


                }
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}