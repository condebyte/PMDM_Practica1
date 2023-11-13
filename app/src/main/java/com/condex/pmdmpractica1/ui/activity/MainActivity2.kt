package com.condex.pmdmpractica1.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.condex.pmdmpractica1.IMCadapter
import com.condex.pmdmpractica1.databinding.RecyclerViewPesosBinding
import com.condex.pmdmpractica1.ui.adapters.Adapter
import com.condex.pmdmpractica1.data.DataSource

class MainActivity2: AppCompatActivity() {
    private lateinit var binding: RecyclerViewPesosBinding
    private lateinit var imcadapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RecyclerViewPesosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
    }
    private fun setData() {
        imcadapter = Adapter(this, DataSource.dataSourceIMC.getImc(this))
        binding.imclist1.adapter = imcadapter
        binding.imclist1.setHasFixedSize(true)
        binding.imclist1.layoutManager = LinearLayoutManager(this)
    }
}