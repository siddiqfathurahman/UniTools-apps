package com.example.a7agustus

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class VisiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_visi)

        // Initialize EditText and Buttons
        val buttonGoBack3: Button = findViewById(R.id.buttonGoBack3)

        // Set up Go Back button
        buttonGoBack3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }

        val buttonGoPeta: Button = findViewById(R.id.buttonGoPeta)
        buttonGoPeta.setOnClickListener {
            // Intent untuk membuka URL website Visi Misi
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://maps.app.goo.gl/dYZNxqkmn51i7Nh18")
            startActivity(intent)
        }
    }
}