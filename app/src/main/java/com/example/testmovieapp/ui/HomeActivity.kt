package com.example.testmovieapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testmovieapp.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId = intent.getStringExtra("user_id")
        val email = intent.getStringExtra("email_id")

        with (binding) {
            tvHomeEmail.text = email
            tvHomeUid.text = userId
            btnLogout.setOnClickListener {
                FirebaseAuth.getInstance().signOut()

                startActivity(Intent(this@HomeActivity, LoginActivity::class.java))
                finish()
            }
        }
    }
}