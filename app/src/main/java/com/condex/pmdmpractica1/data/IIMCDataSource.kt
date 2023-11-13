package com.condex.pmdmpractica1.data

import android.content.Context

interface IIMCDataSource {
    fun getImc(context: Context): ArrayList<IMC>
    fun saveImc(context: Context, car: IMC)
    fun deleteImc(context: Context, car: IMC)
}