package com.example.a7agustus

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AdiwiyataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adiwiyata)

        val textView = findViewById<TextView>(R.id.textViewadi)
        textView.text = "SELAMAT KAMU MASUK KE DALAM HALAMAN ADIWIYATA"

        val buttonGoBack = findViewById<Button>(R.id.buttonGoBack)
        buttonGoBack.setOnClickListener {
            // Navigate back to the previous activity
            finish()
        }
    }
}