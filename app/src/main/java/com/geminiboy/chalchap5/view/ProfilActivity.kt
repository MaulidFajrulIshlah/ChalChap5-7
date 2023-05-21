package com.geminiboy.chalchap5.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geminiboy.chalchap5.databinding.ActivityProfilBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfilBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateUsername()
        binding.Logout.setOnClickListener {
            auth = FirebaseAuth.getInstance()
            Firebase.auth.signOut()
            Toast.makeText(this, "Logout Berhasil", Toast.LENGTH_SHORT).show()
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateUsername() {
        sharedPreferences = getSharedPreferences("InsertAcc", Context.MODE_PRIVATE)
        binding.Update.setOnClickListener {
            val getUsername = binding.uss.text.toString()
            var getNamaLengkap = binding.Nama.text.toString()
            var getTanggalLahir = binding.TglLahir.text.toString()
            var getAlamat = binding.Alamat.text.toString()
            val updateUser = sharedPreferences.edit()
            updateUser.putString("uss", getUsername)
            updateUser.apply()
            Toast.makeText(this, "UpdateBerhasil", Toast.LENGTH_SHORT).show()
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}