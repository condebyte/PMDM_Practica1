package com.condex.pmdmpractica1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.condex.pmdmpractica1.databinding.RecyclerViewPesosBinding
import com.condex.pmdmpractica1.Adapter
import com.condex.pmdmpractica1.IMC

class MainActivity2: AppCompatActivity() {
    private lateinit var binding: RecyclerViewPesosBinding
    private lateinit var imcadapter:Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RecyclerViewPesosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
    }
    private fun setData() {
        imcadapter = Adapter(this, DataSource.dataSourceIMC.getImc(this))
        binding.imclist1.adapter = imcadapter

    }
}