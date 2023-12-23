package com.example.palindromechecker.ui.third

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.palindromechecker.R
import com.example.palindromechecker.databinding.ActivityFirstBinding
import com.example.palindromechecker.databinding.ActivitySecondBinding
import com.example.palindromechecker.databinding.ActivityThirdBinding
import com.example.palindromechecker.ui.ViewModelFactory

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    private val viewModel by viewModels<ThirdViewModel> {
        ViewModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.baseline_arrow_back_ios_24)
        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        setUpRecyclerView()
        val layoutManager = LinearLayoutManager(this)
        binding.rvUser.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvUser.addItemDecoration(itemDecoration)
        onRefreshed()
    }

    private fun setUpRecyclerView() {
        val adapter = UserAdapter()
        binding.rvUser.adapter = adapter
        viewModel.getUser().observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }

    private fun onRefreshed() {
        binding.swipeLayout.setOnRefreshListener {
            setUpRecyclerView()
            binding.swipeLayout.isRefreshing = false
        }
    }
}