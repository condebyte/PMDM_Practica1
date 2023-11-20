package com.condex.pmdmpractica1.ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.condex.pmdmpractica1.databinding.ActivityMainActivityparapasaraFragmentBinding

class MainActivitypasadodeFragment: Fragment() {
    private lateinit var binding: ActivityMainActivityparapasaraFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityMainActivityparapasaraFragmentBinding.inflate(inflater)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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