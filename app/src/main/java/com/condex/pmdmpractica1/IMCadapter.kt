package com.condex.pmdmpractica1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.condex.pmdmpractica1.data.IMC
import com.condex.pmdmpractica1.databinding.ActivityRecyclerItemBinding

class IMCadapter():BaseAdapter() {
    private lateinit var context: Context
    private lateinit var list :ArrayList<IMC>

    constructor( context: Context, list :ArrayList<IMC>) : this() {
        this.context = context
        this.list = list
    }

    override fun getCount(): Int {
        return this.list.size
    }

    override fun getItem(position: Int): Any {
        return this.list[position]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val item = this.list[position]
        val inflator = context!!.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE
        ) as LayoutInflater
        val binding = ActivityRecyclerItemBinding.inflate(inflator)

        //binding.txtdata.text = item.data
        binding.txtInfo.text = item.infoTxt
        binding.txtsexo.text = item.genero
        return binding.root
    }
    fun setData(imc: java.util.ArrayList<IMC>) {

        this.list = imc
    }
}