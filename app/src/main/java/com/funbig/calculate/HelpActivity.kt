package com.funbig.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.funbig.calculate.databinding.ActivityHelpBinding

class HelpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHelpBinding
    private var list = listOf(R.id.firstFragment,R.id.secondFragment,R.id.fragmentThird,R.id.fragmentFour)
    private var ind = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView1) as NavHostFragment
        val controller: NavController = navHostFragment.navController
        binding.button7.setOnClickListener {
            if(!controller.popBackStack()) finish()
            ind--
        }
        binding.button8.setOnClickListener {
            if(ind+1<list.size) {
                ind++
                controller.navigate(list[ind])
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.bg3.setBackgroundResource(getSharedPreferences("prefs", MODE_PRIVATE).getInt("bg",R.color.first))
    }
}