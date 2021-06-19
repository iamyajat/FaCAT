package com.yajatmalhotra.catnip.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.yajatmalhotra.catnip.databinding.ActivityMainBinding
import com.yajatmalhotra.catnip.viewmodel.CatFactViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CatFactViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.layout.setOnClickListener {
            viewModel.getCatFact()
        }

        viewModel.catFactResp.observe(
            this,
            { catFact ->
                binding.catFact.text = catFact.text
            }
        )
    }
}
