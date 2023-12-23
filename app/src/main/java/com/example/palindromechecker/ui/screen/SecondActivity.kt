package com.example.palindromechecker.ui.screen

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.palindromechecker.R
import com.example.palindromechecker.databinding.ActivitySecondBinding
import com.example.palindromechecker.ui.third.ThirdActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.baseline_arrow_back_ios_24)
        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val name = intent.getStringExtra("name")
        binding.tvName.text = name

        val username = intent.getStringExtra("username")
        binding.tvSelectedUsername.text = username

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}