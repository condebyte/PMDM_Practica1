package com.condex.pmdmpractica1.ui.activity

import MainFragment2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.condex.pmdmpractica1.databinding.ActivityMainActivityparapasaraFragmentBinding
import com.condex.pmdmpractica1.ui.Fragments.MainFragment
import com.example.prueba.ui.adapters.FragmentAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivityFragment : AppCompatActivity() {

    private lateinit var binding: ActivityMainActivityparapasaraFragmentBinding
    private lateinit var adapter: FragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainActivityparapasaraFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewPager()
        setupTabLayout()
    }
    private fun setupViewPager() {
        adapter = FragmentAdapter(supportFragmentManager, lifecycle)
        adapter.AddFragment(MainFragment(), "Calculadora")
        adapter.AddFragment(MainFragment2(), "Registro")
        // Añade aquí más fragmentos según sea necesario

        binding.viewPager2.adapter = adapter
    }
    private fun setupTabLayout() {
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager2

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()
    }



    private fun setData() {
        TODO("Not yet implemented")
    }

    private fun setListener() {
        TODO("Not yet implemented")
    }
}