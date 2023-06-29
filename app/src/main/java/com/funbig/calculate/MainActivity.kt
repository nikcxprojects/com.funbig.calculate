package com.funbig.calculate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.funbig.calculate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button2.setOnClickListener {
            startActivity(Intent(applicationContext,ThemeActivity::class.java))
        }
        binding.button3.setOnClickListener {
            startActivity(Intent(applicationContext, HelpActivity::class.java))
        }
        binding.button.setOnClickListener {
            startActivity(Intent(applicationContext, CalculatorActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        binding.bg1.setBackgroundResource(getSharedPreferences("prefs", MODE_PRIVATE).getInt("bg",R.color.first))
    }
}