package com.condex.pmdmpractica1

object datosHistoricoIMC{
    private val imcs = ArrayList<IMC>()

    init

    fun getImcs(): ArrayList<IMC> {
        return imcs
    }

    fun saveCar(car :IMC){
        imcs.add(car)
    }

    fun deleteCar(car :IMC){
        imcs.remove(car)
    }
}


