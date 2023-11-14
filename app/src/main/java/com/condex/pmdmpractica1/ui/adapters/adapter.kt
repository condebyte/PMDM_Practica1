package com.condex.pmdmpractica1.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.condex.pmdmpractica1.data.IMC
import com.condex.pmdmpractica1.databinding.ActivityRecyclerItemBinding

class Adapter(
    private val context: Context,
    private var list: ArrayList<IMC>
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(val binding: ActivityRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.txtanyo.text = item.año
        holder.binding.txtmes.text = item.mes
        holder.binding.txtdia.text = item.dia
        holder.binding.txtInfo.text = item.infoTxt
        holder.binding.txtsexo.text = item.genero
        holder.binding.txtimc.text = item.imc.toString()
    }

    override fun getItemCount(): Int = list.size

    fun setData(newList: ArrayList<IMC>) {
        list = newList
        notifyDataSetChanged() // Notify any registered observers that the data set has changed.
    }
}