package com.example.testmovieapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.testmovieapp.databinding.ActivityLoginBinding
import com.example.testmovieapp.databinding.ActivityMainBinding
import com.example.testmovieapp.repositories.AuthenticationRepository
import com.example.testmovieapp.ui.viewmodels.AuthenticationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Activity is not really in use, just wanted to test out again navigation graph and fragments
    // App starting with LoginActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}