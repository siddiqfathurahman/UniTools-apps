package com.example.a7agustus

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class QrActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the orientation to portrait
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContentView(R.layout.activity_qr)

        // Initialize TextView
        val textView = findViewById<TextView>(R.id.textViewqr)
        textView.text = "SELAMAT KAMU MASUK KE DALAM HALAMAN QR CODE"

        // Button to navigate back to the previous activity
        val buttonGoBack = findViewById<Button>(R.id.buttonGoBack)
        buttonGoBack.setOnClickListener {
            finish() // Go back to the previous activity
        }

        // Button to start scanning QR code
        val scanButton: Button = findViewById(R.id.btn_scan_qr)
        scanButton.setOnClickListener {
            // Initialize IntentIntegrator to scan QR code
            val intentIntegrator = IntentIntegrator(this)
            intentIntegrator.setPrompt("Scan a QR code")
            intentIntegrator.setOrientationLocked(false) // Optional: Set to true if you want to lock orientation
            intentIntegrator.setBeepEnabled(true)
            intentIntegrator.initiateScan()
        }
    }

    // Handle scan result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result: IntentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Scan cancelled", Toast.LENGTH_SHORT).show()
            } else {
                // Display scanned result
                Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
