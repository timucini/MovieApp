package com.example.testmovieapp.data.firebase

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

class FirebaseSource {

    private val auth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    private lateinit var user: FirebaseUser


    fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                    task ->
                if (task.isSuccessful) {
                    Log.d("FireBaseAuth", "createUserWithEmail:success")
                    user = auth.currentUser!!
                } else {
                    Log.d("FireBaseAuth", "createUserWithEmail:failure", task.exception)
                }
            }
    }

    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                    task ->
                if (task.isSuccessful) {
                    Log.d("FireBaseAuth", "signInWithEmail:success")
                } else {
                    Log.d("FireBaseAuth", "signInWithEmail:failure", task.exception)
                }
            }
    }

}