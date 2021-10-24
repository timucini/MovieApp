package com.example.testmovieapp.repositories

import com.example.testmovieapp.data.firebase.FirebaseSource
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(
    private val firebaseSource: FirebaseSource
) {

    fun register(email : String, password: String) {
        firebaseSource.register(email,password)
    }

    fun login(email : String, password: String) {
        firebaseSource.login(email, password)
    }
}