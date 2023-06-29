package com.funbig.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.funbig.calculate.databinding.ActivityThemeBinding

class ThemeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThemeBinding
    private var list = mutableListOf<Int>(R.color.first,R.color.second,R.color.third, R.color.four)
    private var ind = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThemeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ind = list.indexOf(getSharedPreferences("prefs", MODE_PRIVATE).getInt("bg",R.color.first))
        binding.imageView3.setBackgroundResource(list[ind])
        binding.button4.setOnClickListener {
            ind = (ind-1)
            if(ind<0) ind = list.size-1
            binding.imageView3.setBackgroundResource(list[ind])
        }
        binding.button5.setOnClickListener {
            ind = (ind+1)%list.size
            binding.imageView3.setBackgroundResource(list[ind])
        }
        binding.button6.setOnClickListener {
            getSharedPreferences("prefs", MODE_PRIVATE).edit()
                .putInt("bg",list[ind]).apply()
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        binding.bg2.setBackgroundResource(getSharedPreferences("prefs", MODE_PRIVATE).getInt("bg",R.color.first))
    }
}