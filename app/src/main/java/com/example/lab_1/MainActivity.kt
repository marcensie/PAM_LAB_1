package com.example.lab_1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate_btn.setOnClickListener {
            val height = (etHeight.text.toString()).toInt()
            val weight = (etWeight.text.toString()).toInt()

            val BMI = calculateBMI(height, weight)
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
            bmi_tv.visibility = View.VISIBLE
            status.visibility = View.VISIBLE
        }
    }

    private fun calculateBMI(height: Int, weight: Int): Float {
        val doubleHeight = height.toFloat() / 100
        val BMI = weight.toFloat() / (doubleHeight * doubleHeight)
        return BMI
    }
}