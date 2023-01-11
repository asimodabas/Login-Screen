package com.asimodabas.kotlinproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asimodabas.kotlinproject.databinding.ActivityAnaEkranBinding

class AnaEkranActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnaEkranBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnaEkranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sp = getSharedPreferences("GirisBilgi", Context.MODE_PRIVATE)
        val ka = sp.getString("kullaniciAdi", "Kullanıcı adı yok")
        val s = sp.getString("sifre", "Şifre adı yok")

        var cikis = " "
        cikis += "\n" + "User Name = $ka"
        cikis += "\n" + "Password = $s"
        binding.textViewCikti.text = cikis

        binding.buttonCikisYap.setOnClickListener {
            val editor = sp.edit()
            editor.remove("kullaniciAdi")
            editor.remove("sifre")
            editor.apply()

            startActivity(Intent(this@AnaEkranActivity, MainActivity::class.java))
            finish()
        }
    }
}