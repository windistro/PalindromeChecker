package com.example.palindromechecker.ui.third

import androidx.lifecycle.ViewModel
import com.example.palindromechecker.data.Repository

class ThirdViewModel(private val repository: Repository) : ViewModel() {
    fun getUser() = repository.getUser()
}