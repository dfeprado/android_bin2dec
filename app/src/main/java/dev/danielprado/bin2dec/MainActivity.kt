package dev.danielprado.bin2dec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import dev.danielprado.bin2dec.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var layoutBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(layoutBinding.root)

        layoutBinding.binaryInput.setOnKeyListener(object: View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if (event?.action == KeyEvent.ACTION_DOWN && keyCode != KeyEvent.KEYCODE_0 && keyCode != KeyEvent.KEYCODE_1) {
                    Toast.makeText(applicationContext, "Only 0 and 1 allowed", Toast.LENGTH_SHORT)
                            .show()
                    return true
                }
                return false;
            }
        })

        layoutBinding.convertButton.setOnClickListener {
            convertBin2Dec()
        }
    }

    private fun convertBin2Dec() {
        val binDigits = layoutBinding.binaryInput.text
        var decimal = 0;

        for (digit in binDigits)
            decimal = decimal * 2 + "$digit".toInt()

        layoutBinding.decimalInput.setText(decimal.toString())
    }
}