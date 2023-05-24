package com.geminiboy.chalchap5.view

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.geminiboy.chalchap5.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var auth: FirebaseAuth
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val crashButton = Button(this)
        crashButton.text = "Test Crash"
        crashButton.setOnClickListener {
            throw RuntimeException("Test Crash") // Force a crash
        }

        addContentView(crashButton, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT))
        binding.Register.setOnClickListener {
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        getAcc()
    }

    @SuppressLint("SuspiciousIndentation")
    fun getAcc(){
        sharedPreferences = getSharedPreferences("InsertAcc", MODE_PRIVATE)
        binding.btnLogin.setOnClickListener {
            val getEmail = sharedPreferences.getString("email", "")
            val getPass = sharedPreferences.getString("pass", "")
            val email = binding.insEmail.text.toString()
            val pass = binding.insPass.text.toString()
            if(email == getEmail.toString() && pass == getPass.toString()){
                signInWithEmailAndPassword(email = getEmail.toString(), password = getPass.toString())
            }
        }
    }
    private fun signInWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login berhasil
                    Toast.makeText(this,"Login Berhasil", Toast.LENGTH_SHORT).show()
                    intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this,"Login Gagal", Toast.LENGTH_SHORT).show()
                }
            }
    }
}