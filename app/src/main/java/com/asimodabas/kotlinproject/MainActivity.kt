package com.asimodabas.kotlinproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.asimodabas.kotlinproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, CreateActivity::class.java))
        }

        binding.textView.setOnClickListener {
            Toast.makeText(this, "Yardım isteği iletildi", Toast.LENGTH_SHORT).show()
        }

        val sp = getSharedPreferences("GirisBilgi", Context.MODE_PRIVATE)
        val ogka = sp.getString("kullaniciAdi", "Kullanıcı adı yok")
        val ogs = sp.getString("sifre", "Şifre adı yok")

        if (ogka == "admin" && ogs == "123") {
            startActivity(Intent(this@MainActivity, AnaEkranActivity::class.java))
            finish()
        }

        binding.button.setOnClickListener {
            val ka = binding.editTextTextPersonName.text.toString()
            val s = binding.editTextTextPersonName2.text.toString()

            if (ka == "admin" && s == "123") {
                val editor = sp.edit()
                editor.putString("kullaniciAdi", ka)
                editor.putString("sifre", s)
                editor.apply()

                startActivity(Intent(this@MainActivity, AnaEkranActivity::class.java))
                finish()

            } else {
                Toast.makeText(applicationContext, "Hatalı Giriş", Toast.LENGTH_SHORT).show()
            }
        }
    }
}