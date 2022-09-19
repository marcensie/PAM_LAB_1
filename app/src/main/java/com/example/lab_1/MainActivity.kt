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
        val calc_btn = findViewById<Button>(R.id.calculate_btn)


        calc_btn.setOnClickListener {
            var weightValue = 0.0
            var heightValue = 0.0
            if (weight.text.toString().isNotEmpty()) {
                weightValue = weight.text.toString().toDouble()
            }
            if (height.text.toString().isNotEmpty()) {
                heightValue = (height.text.toString().toDouble() / 100)
            }
            val index = calc(heightValue, weightValue)
            bmi.text = index.toString()
            bmi.visibility = View.VISIBLE

            if (index < 18.5) {
                status.text = "Under Weight"
            } else if (index >= 18.5 && index < 24.9) {
                status.text = "Healthy"
            } else if (index >= 25 && index < 30) {
                status.text = "Overweight"
            } else  {
                status.text = "Obese"
            }
            val ed=String.format("%.2f",index)
            bmi.text =ed
            bmi.visibility = View.VISIBLE
            status.visibility = View.VISIBLE
        } }
    private fun calc(height: Double, weight: Double): Double {
        val index = weight / (height * height)
        return index
    }
}