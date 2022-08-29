package com.example.cookingconverter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.cookingconverter.databinding.ActivityMainBinding
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var converted: Double = 0.0
    private var convertTo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            val amount = binding.editTextAmount.text.toString().toDoubleOrNull()
            if (amount != null) {
                calculateConversion(amount)
            }
        }

        binding.editTextAmount.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(
                view,
                keyCode
            )
        }
    }


    private fun calculateConversion(amount: Double) {
        Log.v(TAG, "Calculate Convert Start!")
        Log.v(TAG, binding.radioGroup.checkedRadioButtonId.toString())

        if (binding.radioGroup.checkedRadioButtonId != -1 &&
            binding.radioGroup2.checkedRadioButtonId != -1) {
            Log.v(TAG, "Passed Binding")
            when (binding.radioGroup.checkedRadioButtonId) {
                R.id.cups_from -> cupsFrom(amount)
                R.id.tsp_from -> tspFrom(amount)
                R.id.tbs_from -> tbsFrom(amount)
                R.id.qt_from -> qtFrom(amount)
                R.id.pt_from -> ptFrom(amount)
                R.id.oz_from -> ozFrom(amount)
                else -> converted = amount
            }
        setText()
        }


    }

    private fun setText() {
        val convertText = "Conversion Result: $converted $convertTo"
        binding.conversionResult.text = convertText
    }

    private fun cupsFrom(amount: Double) {
        Log.v(TAG, "Cups From Started")
        when (binding.radioGroup2.checkedRadioButtonId) {
            R.id.tsp_to -> cupsToTsp(amount)
            R.id.tbs_to -> cupsToTbs(amount)
            R.id.qt_to -> cupsToQt(amount)
            R.id.pt_to -> cupsToPt(amount)
            R.id.oz_to -> cupsToOz(amount)
            else -> converted = amount

        }
    }

    private fun tspFrom(amount: Double) {
        Log.v(TAG, "Tsp From Started")
        when (binding.radioGroup2.checkedRadioButtonId) {
            R.id.cups_to -> tspToCups(amount)
            R.id.tbs_to -> tspToTbs(amount)
            R.id.qt_to -> tspToQt(amount)
            R.id.pt_to -> tspToPt(amount)
            R.id.oz_to -> tspToOz(amount)
            else -> converted = amount

        }
    }

    private fun tbsFrom(amount: Double) {
        Log.v(TAG, "Tbs From Started")
        when (binding.radioGroup2.checkedRadioButtonId) {
            R.id.cups_to -> tbsToCups(amount)
            R.id.tsp_to -> tbsToTsp(amount)
            R.id.qt_to -> tbsToQt(amount)
            R.id.pt_to -> tbsToPt(amount)
            R.id.oz_to -> tbsToOz(amount)
            else -> converted = amount

        }
    }

    private fun qtFrom(amount: Double) {
        Log.v(TAG, "Qt From Started")
        when (binding.radioGroup2.checkedRadioButtonId) {
            R.id.cups_to -> qtToCups(amount)
            R.id.tsp_to -> qtToTsp(amount)
            R.id.tbs_to -> qtToTbs(amount)
            R.id.pt_to -> qtToPt(amount)
            R.id.oz_to -> qtToOz(amount)
            else -> converted = amount

        }
    }

    private fun ptFrom(amount: Double) {
        Log.v(TAG, "Pt From Started")
        when (binding.radioGroup2.checkedRadioButtonId) {
            R.id.cups_to -> ptToCups(amount)
            R.id.tsp_to -> ptToTsp(amount)
            R.id.tbs_to -> ptToTbs(amount)
            R.id.qt_to -> ptToQt(amount)
            R.id.oz_to -> ptToOz(amount)
            else -> converted = amount

        }
    }

    private fun ozFrom(amount: Double) {
        Log.v(TAG, "Oz From Started")
        when (binding.radioGroup2.checkedRadioButtonId) {
            R.id.cups_to -> ozToCups(amount)
            R.id.tsp_to -> ozToTsp(amount)
            R.id.tbs_to -> ozToTbs(amount)
            R.id.qt_to -> ozToQt(amount)
            R.id.pt_to -> ozToPt(amount)
            else -> converted = amount

        }
    }

    private fun cupsToTsp (amount: Double) {
        converted = amount * 48
        convertTo = "Tsp."
    }
    private fun cupsToTbs (amount: Double) {
        converted = amount * 16
        convertTo = "Tbs."
    }
    private fun cupsToQt (amount: Double) {
        converted = amount / 4
        convertTo = "Qt."
    }
    private fun cupsToPt (amount: Double) {
        converted = amount / 2
        convertTo = "Pt."
    }
    private fun cupsToOz (amount: Double) {
        converted = amount * 8
        convertTo = "Oz."
    }
    private fun tspToCups (amount: Double) {
        converted = amount / 48
        convertTo = "Cups."
    }
    private fun tspToTbs (amount: Double) {
        converted = amount / 3
        convertTo = "Tbs."
    }
    private fun tspToQt (amount: Double) {
        converted = amount / 192
        convertTo = "Qt."
    }
    private fun tspToPt (amount: Double) {
        converted = amount / 96
        convertTo = "Pt."
    }
    private fun tspToOz (amount: Double) {
        converted = amount / 6
        convertTo = "Oz."
    }
    private fun tbsToCups (amount: Double) {
        converted = amount / 16
        convertTo = "Cups."
    }
    private fun tbsToTsp (amount: Double) {
        converted = amount * 3
        convertTo = "Tsp."
    }
    private fun tbsToQt (amount: Double) {
        converted = amount / 64
        convertTo = "Qt."
    }
    private fun tbsToPt (amount: Double) {
        converted = amount / 32
        convertTo = "Pt."
    }
    private fun tbsToOz (amount: Double) {
        converted = amount / 2
        convertTo = "Oz."
    }
    private fun qtToCups (amount: Double) {
        converted = amount * 4
        convertTo = "Cups."
    }
    private fun qtToTsp (amount: Double) {
        converted = amount * 192
        convertTo = "Tsp."
    }
    private fun qtToTbs (amount: Double) {
        converted = amount * 64
        convertTo = "Tbs."
    }
    private fun qtToPt (amount: Double) {
        converted = amount * 2
        convertTo = "Pt."
    }
    private fun qtToOz (amount: Double) {
        converted = amount * 32
        convertTo = "Oz."
    }
    private fun ptToCups (amount: Double) {
        converted = amount * 2
        convertTo = "Cups."
    }
    private fun ptToTsp (amount: Double) {
        converted = amount * 96
        convertTo = "Tsp."
    }
    private fun ptToTbs (amount: Double) {
        converted = amount * 32
        convertTo = "Tbs."
    }
    private fun ptToQt (amount: Double) {
        converted = amount / 2
        convertTo = "Qt."
    }
    private fun ptToOz (amount: Double) {
        converted = amount * 16
        convertTo = "Oz."
    }
    private fun ozToCups (amount: Double) {
        converted = amount / 8
        convertTo = "Cups."
    }
    private fun ozToTsp (amount: Double) {
        converted = amount * 6
        convertTo = "Tsp."
    }
    private fun ozToTbs (amount: Double) {
        converted = amount * 2
        convertTo = "Tbs."
    }
    private fun ozToQt (amount: Double) {
        converted = amount / 32
        convertTo = "Qt."
    }
    private fun ozToPt (amount: Double) {
        converted = amount / 16
        convertTo = "Pt."
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}
