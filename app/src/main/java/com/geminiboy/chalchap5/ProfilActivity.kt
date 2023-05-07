package com.geminiboy.chalchap5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geminiboy.chalchap5.databinding.ActivityHomeBinding
import com.geminiboy.chalchap5.databinding.ActivityProfilBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfilActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfilBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var auth: FirebaseAuth

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

    fun updateUsername() {
        sharedPreferences = getSharedPreferences("InsertAcc", Context.MODE_PRIVATE)
        binding.Update.setOnClickListener {
            var getUsername = binding.uss.text.toString()
            var getNamaLengkap = binding.Nama.text.toString()
            var getTanggalLahir = binding.TglLahir.text.toString()
            var getAlamat = binding.Alamat.text.toString()
            var updateUser = sharedPreferences.edit()
            updateUser.putString("uss", getUsername)
            updateUser.apply()
            Toast.makeText(this, "UpdateBerhasil", Toast.LENGTH_SHORT).show()
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}