package com.example.a7agustus

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private var operand1: Double? = null
    private var operator: String? = null
    private var isNewOperation = true

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_second) // Pastikan Anda menggunakan layout yang benar

        // Initialize EditText and Buttons
        editText = findViewById(R.id.editText)
        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val buttonDot: Button = findViewById(R.id.buttonComma) // Diganti sesuai XML
        val buttonAdd: Button = findViewById(R.id.buttonPlus) // Diganti sesuai XML
        val buttonSub: Button = findViewById(R.id.buttonMinus) // Diganti sesuai XML
        val buttonMul: Button = findViewById(R.id.buttonMultiply) // Diganti sesuai XML
        val buttonDiv: Button = findViewById(R.id.buttonDivide) // Diganti sesuai XML
        val buttonEq: Button = findViewById(R.id.buttonEqual) // Diganti sesuai XML
        val buttonClear: Button = findViewById(R.id.buttonAC) // Diganti sesuai XML
        val buttonPlusMinus: Button = findViewById(R.id.buttonPlusMinus)
        val buttonPercent: Button = findViewById(R.id.buttonPercent)
        val buttonGoBack: Button = findViewById(R.id.buttonGoBack)

        // Set up number buttons
        val numberButtons = listOf(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9)
        numberButtons.forEach { button ->
            button.setOnClickListener { appendNumber(button.text.toString()) }
        }

        // Set up operator buttons
        buttonDot.setOnClickListener { appendNumber(buttonDot.text.toString()) }
        buttonAdd.setOnClickListener { setOperator(buttonAdd.text.toString()) }
        buttonSub.setOnClickListener { setOperator(buttonSub.text.toString()) }
        buttonMul.setOnClickListener { setOperator(buttonMul.text.toString()) }
        buttonDiv.setOnClickListener { setOperator(buttonDiv.text.toString()) }
        buttonEq.setOnClickListener { calculateResult() }

        // Set up Clear button
        buttonClear.setOnClickListener {
            editText.setText("0")
            operand1 = null
            operator = null
            isNewOperation = true
        }

        // Set up Go Back button
        buttonGoBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }

        // Optional: Implement buttonPlusMinus and buttonPercent functionality if needed
    }

    private fun appendNumber(value: String) {
        if (isNewOperation) {
            editText.text.clear()
            isNewOperation = false
        }
        if (editText.text.toString() == "0") {
            editText.text.clear()
        }
        editText.append(value)
    }

    private fun setOperator(op: String) {
        if (operand1 == null) {
            operand1 = editText.text.toString().toDoubleOrNull()
            editText.append(op)
        } else {
            calculateResult()  // Hitung jika ada operand1 dan operator sebelumnya
            operand1 = editText.text.toString().toDoubleOrNull()
            editText.append(op)
        }
        operator = op
        isNewOperation = false
    }

    private fun calculateResult() {
        if (operator != null && operand1 != null) {
            val operand2Text = editText.text.toString().substringAfterLast(operator!!).trim()
            val operand2 = operand2Text.toDoubleOrNull()
            if (operand2 != null) {
                val result = performCalculation(operand2)
                if (result != null) {
                    editText.setText(result.toString())
                    operand1 = null
                    operator = null
                    isNewOperation = true
                }
            }
        }
    }

    private fun performCalculation(operand2: Double): Double? {
        return when (operator) {
            "+" -> operand1!! + operand2
            "-" -> operand1!! - operand2
            "×" -> operand1!! * operand2
            "÷" -> {
                if (operand2 == 0.0) {
                    editText.setText("Error")
                    null
                } else {
                    operand1!! / operand2
                }
            }
            else -> null
        }
    }
}
