package dev.danielprado.bin2dec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import dev.danielprado.bin2dec.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var layoutBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(layoutBinding.root)

        layoutBinding.convertButton.setOnClickListener {
            convertBin2Dec()
        }
    }

    private fun convertBin2Dec() {
        val binDigits = layoutBinding.binaryInput.text.reversed()
        var decimal = 0.0;

        for (index in binDigits.length - 1 downTo 0) {
            if (binDigits[index] == '1') {
                decimal += Math.pow(2.0, index.toDouble())
            }
        }
        layoutBinding.decimalInput.setText(decimal.toInt().toString())
    }
}