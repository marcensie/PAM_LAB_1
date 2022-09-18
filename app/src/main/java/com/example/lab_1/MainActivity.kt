package com.example.lab_1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight = findViewById<EditText>(R.id.weight_val)
        val height = findViewById<EditText>(R.id.height_val)
        val calculate_btn = findViewById<Button>(R.id.calculate_btn)


        calculate_btn.setOnClickListener {
            var weightValue = 0.0
            var heightValue = 0.0
            if (weight.text.toString().isNotEmpty()) {
                weightValue = weight.text.toString().toDouble()
            }
            if (height.text.toString().isNotEmpty()) {
                heightValue = (height.text.toString().toDouble() / 100)
            }
            val BMI = calculateBMI(heightValue, weightValue)
            bmi.text = BMI.toString()
            bmi.visibility = View.VISIBLE

            if (BMI < 18.5) {
                status.text = "Under Weight"
            } else if (BMI >= 18.5 && BMI < 24.9) {
                status.text = "Healthy"
            } else if (BMI >= 25 && BMI < 30) {
                status.text = "Overweight"
            } else  {
                status.text = "Obese"
            }
            val ed=String.format("%.2f",BMI)
            bmi.text =ed
            bmi.visibility = View.VISIBLE
            status.visibility = View.VISIBLE
        }
    }

    private fun calculateBMI(height: Double, weight: Double): Double {
        val BMI = weight / (height * height)
        return BMI
    }
}