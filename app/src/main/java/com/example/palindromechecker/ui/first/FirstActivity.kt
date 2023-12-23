package com.example.palindromechecker.ui.first

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.palindromechecker.R
import com.example.palindromechecker.databinding.ActivityFirstBinding
import com.example.palindromechecker.ui.screen.SecondActivity

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        isPalindrome()

        binding.btnNext.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            if (name.isEmpty()) {
                Toast.makeText(this, "fill your name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
            }
        }
    }

    private fun isPalindrome() {
        binding.btnCheck.setOnClickListener {
            val palindrome = binding.palindromeEditText.text.toString()
            val palindromeWithoutSpaces = palindrome.replace("\\s".toRegex(), "")
            if (palindromeWithoutSpaces.isNotEmpty()) {
                if (palindromeWithoutSpaces == palindromeWithoutSpaces.reversed()) {
                    AlertDialog.Builder(this).apply {
                        setMessage("$palindrome is Palindrome")
                        setPositiveButton("OK") { _, _ -> }
                        create()
                        show()
                    }
                } else {
                    AlertDialog.Builder(this).apply {
                        setMessage("$palindrome is not Palindrome")
                        setPositiveButton("Lanjut") { _, _ -> }
                        create()
                        show()
                    }
                }
            }
        }
    }
}