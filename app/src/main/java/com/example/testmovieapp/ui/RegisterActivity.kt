package com.example.testmovieapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.testmovieapp.R
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_register.*

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegisterActivity.setOnClickListener {
            when {
                TextUtils.isEmpty(etEmailRegisterActivity.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter Email",
                        Toast.LENGTH_LONG
                    ).show()
                }
                TextUtils.isEmpty(etPasswordRegisterActivity.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter Password",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else -> {
                    val email: String = etEmailRegisterActivity.text.toString().trim { it <= ' '}
                    val password: String = etPasswordRegisterActivity.text.toString().trim { it <= ' '}

                    val auth = FirebaseAuth.getInstance()
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this@RegisterActivity) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("FireBase Auth", "createUserWithEmail:success")
                                val user = auth.currentUser!!
                                Toast.makeText(this@RegisterActivity,"successfully registered",Toast.LENGTH_LONG).show()
                                val intent = Intent(this@RegisterActivity, HomeActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id",user.uid)
                                intent.putExtra("email_id",email)
                                startActivity(intent)
                                finish()
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.d("FireBase Auth", "createUserWithEmail:failure", task.exception)
                                Toast.makeText(baseContext, "Authentication failed." + task.exception.toString(),
                                    Toast.LENGTH_SHORT).show()
                            }
                        }

                }
            }
        }
        tvLoginReference.setOnClickListener {
            onBackPressed()
        }
    }
}