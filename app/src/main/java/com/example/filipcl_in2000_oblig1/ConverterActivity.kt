package com.example.filipcl_in2000_oblig1

import android.app.ListActivity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_converter.*

class ConverterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        fun View.hideKeyboeard() {
            val hide = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            hide.hideSoftInputFromWindow(windowToken, 0)
        }

        val converterButton: Button = findViewById(R.id.ConverterButton)
        converterButton.setOnClickListener {
            val check : EditText = findViewById(R.id.cmInput)
            val checkString = check.text.toString()
            if(checkString.isBlank()){
                Toast.makeText(this, "fyll inn text", Toast.LENGTH_LONG).show()
            }

            val input: Int = cmInput.text.toString().toInt()

            if (input in 0..999999) {

                val cm: Double = cmInput.text.toString().toDouble()
                val output: Double = String.format("%.2f", cm * 0.39).toDouble()

                val textVeiw: TextView = findViewById(R.id.inchesOutput)
                textVeiw.text = (cm.toString() + "cm = " + output.toString() + " Inches")
                cmInput.hideKeyboeard()
            } else
                Toast.makeText(this, "Input not between 0 - 999 999", Toast.LENGTH_LONG).show()
        }

        val nextButton: Button = findViewById(R.id.NextActivity2)
        nextButton.setOnClickListener{
            val intent = Intent(this, com.example.filipcl_in2000_oblig1.ListActivity::class.java)
            startActivity(intent)
        }

    }
}

