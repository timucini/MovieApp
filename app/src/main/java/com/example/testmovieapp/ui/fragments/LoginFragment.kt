package com.example.testmovieapp.ui.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.testmovieapp.databinding.FragmentLoginBinding
import com.example.testmovieapp.ui.viewmodels.AuthenticationViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    @Inject lateinit var viewModel: AuthenticationViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            when {
                TextUtils.isEmpty(binding.etEmailLogin.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                        activity,
                        "Please enter Email",
                        Toast.LENGTH_LONG
                    ).show()
                }
                TextUtils.isEmpty(binding.etPassLogin.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                        activity,
                        "Please enter Password",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else -> {
                    val email: String = binding.etEmailLogin.text.toString().trim { it <= ' '}
                    val password: String = binding.etPassLogin.text.toString().trim { it <= ' '}

                    viewModel.loginToFireBase(email, password)


                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}