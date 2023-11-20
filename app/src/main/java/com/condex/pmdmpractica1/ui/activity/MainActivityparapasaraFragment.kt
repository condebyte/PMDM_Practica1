package com.condex.pmdmpractica1.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.condex.pmdmpractica1.R
import com.condex.pmdmpractica1.databinding.ActivityMainActivityparapasaraFragmentBinding

class MainActivityparapasaraFragment : AppCompatActivity() {
    private lateinit var binding: ActivityMainActivityparapasaraFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainActivityparapasaraFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListener()
        setData()
    }

    private fun setData() {
        TODO("Not yet implemented")
    }

    private fun setListener() {
        TODO("Not yet implemented")
    }
}