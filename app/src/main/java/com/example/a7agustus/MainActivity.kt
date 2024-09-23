package com.example.a7agustus

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referensikan ImageViews berdasarkan ID-nya
        val buttonGoToNext: ImageView = findViewById(R.id.buttonGoToNext)
        val buttonGoToNext2: ImageView = findViewById(R.id.buttonGoToNext2)
        val buttonGoToNext3: ImageView = findViewById(R.id.buttonGoToNext3)
        val buttonGoToNext4: ImageView = findViewById(R.id.buttonGoToNext4)

        // Tombol Klik untuk Kalkulator
        buttonGoToNext.setOnClickListener {
            // Navigasikan ke Aktivitas Kalkulator
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Tombol Klik untuk smk 2
        buttonGoToNext2.setOnClickListener {
            val intent = Intent(this, VisiActivity::class.java)
            startActivity(intent)
        }

        // Tombol Klik untuk qr
        buttonGoToNext3.setOnClickListener {
            val intent = Intent(this, QrActivity::class.java)
            startActivity(intent)
        }

        // Tombol Klik untuk adiwiyata
        buttonGoToNext4.setOnClickListener {
            val intent = Intent(this, AdiwiyataActivity::class.java)
            startActivity(intent)
        }


    }
}
