package com.asimodabas.kotlinproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_ana_ekran.*
import kotlinx.android.synthetic.main.activity_main.*

class AnaEkranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ana_ekran)

        val sp = getSharedPreferences("GirisBilgi", Context.MODE_PRIVATE)

        val ka = sp.getString("kullaniciAdi", "Kullanıcı adı yok")
        val s = sp.getString("sifre", "Şifre adı yok")

        var cikis = " "
        cikis += "\n" + "User Name = $ka"
        cikis += "\n" + "Password = $s"
        textViewCikti.text = cikis



        buttonCikisYap.setOnClickListener {
           val editor=sp.edit()
            editor.remove("kullaniciAdi")
            editor.remove("sifre")
            editor.commit()



            startActivity(Intent(this@AnaEkranActivity, MainActivity::class.java))
            finish()
        }


    }
}