package com.condex.pmdmpractica1.data

object datosHistoricoIMC{
    private val imcs = ArrayList<IMC>()



    fun getImcs(): ArrayList<IMC> {
        return imcs
    }

    fun saveCar(car : IMC){
        imcs.add(car)
    }

    fun deleteCar(car : IMC){
        imcs.remove(car)
    }
}


