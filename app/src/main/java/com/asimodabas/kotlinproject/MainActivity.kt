package com.asimodabas.kotlinproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.setOnClickListener {
            Toast.makeText(this, "Yardım isteği iletildi", Toast.LENGTH_SHORT).show()
        }


        val sp = getSharedPreferences("GirisBilgi", Context.MODE_PRIVATE)

        val ogka = sp.getString("kullaniciAdi", "Kullanıcı adı yok")    //og=otomatik giriş
        val ogs = sp.getString("sifre", "Şifre adı yok")                //og=otomatik giriş

        if (ogka=="admin" && ogs=="123"){

            startActivity(Intent(this@MainActivity, AnaEkranActivity::class.java))
            finish()
        }

        button.setOnClickListener {
            val ka = editTextTextPersonName.text.toString()
            val s = editTextTextPersonName2.text.toString()

            if (ka == "admin" && s == "123") {
                val editor = sp.edit()
                editor.putString("kullaniciAdi", ka)
                editor.putString("sifre", s)
                editor.commit()


                startActivity(Intent(this@MainActivity, AnaEkranActivity::class.java))
                finish()

            } else {
                Toast.makeText(applicationContext, "Hatalı Giriş", Toast.LENGTH_SHORT).show()
            }

        }

    }


}