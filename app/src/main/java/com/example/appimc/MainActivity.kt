package com.example.appimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val heightEditText: EditText = findViewById(R.id.heightEditText)
        val calculateButton: Button = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                val selectedRadioButton: RadioButton = findViewById(selectedRadioButtonId)
                val heightText = heightEditText.text.toString()
                if (heightText.isNotEmpty()) {
                    val height = heightText.toDouble()
                    val weight = calculateWeight(selectedRadioButton.text.toString(), height)
                    val message = "Peso ideal: $weight kg"
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Por favor, insira a altura.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, selecione o sexo.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateWeight(sex: String, height: Double): Double {
        return if (sex.equals("Masculino", ignoreCase = true)) {
            (72.7 * height) - 58
        } else {
            (62.1 * height) - 44.7
        }
    }
}
