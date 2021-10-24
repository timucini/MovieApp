package com.example.testmovieapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.testmovieapp.data.firebase.FirebaseSource
import com.example.testmovieapp.repositories.AuthenticationRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val repository: AuthenticationRepository
    ) : ViewModel() {

        fun registerToFireBase(email: String, password: String ) {
            repository.register(email, password)
        }

        fun loginToFireBase(email: String, password: String ) {
            repository.login(email, password)
        }
}