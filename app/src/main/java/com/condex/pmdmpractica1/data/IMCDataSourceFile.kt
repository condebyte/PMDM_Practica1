package com.condex.pmdmpractica1.data

import android.content.Context
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter

object IMCDataSourceFile: IIMCDataSource {

    val fileName="registro_imc.txt"

    override fun getImc(context: Context): ArrayList<IMC> {
        return readFromFile(context)
    }

    override fun saveImc(context: Context, car: IMC) {
        val imcs = readFromFile(context)
        imcs.add(car)
        saveToFile(context,imcs)
    }

    override fun deleteImc(context: Context, car: IMC) {
        val imcs = readFromFile(context)
        imcs.remove(car)
        saveToFile(context,imcs)
    }

    fun getFile(context: Context): File {
        val carsFile = File(context.filesDir, fileName)
        if (!carsFile.exists()) {
            // Intenta crear el archivo
            try {
                carsFile.createNewFile()
                println("El archivo se ha creado correctamente.")
            } catch (e: Exception) {
                println("Error al crear el archivo: ${e.message}")
            }
        } else {
            println("El archivo ya existe.")
        }
        return carsFile
    }

    fun saveToFile(context: Context,cars: List<IMC>) {
        val carsFile = getFile(context)
        if (carsFile.exists()) {
            val writer = BufferedWriter(FileWriter(carsFile))
            cars.forEach { imc ->
                writer.write("${imc.data};${imc.genero};${imc.imc};${imc.infoTxt}\n")
            }
            writer.close()
        }
    }
    private fun readFromFile(context: Context): ArrayList<IMC> {
        val carsFile = getFile(context)
        val cars = ArrayList<IMC>()
        if (carsFile.exists()) {
            val reader = BufferedReader(FileReader(carsFile))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                val parts = line!!.split(";")
                if (parts.size == 4) {
                    val imc = IMC(parts[0], parts[1], parts[2], parts[3])
                    cars.add(imc)
                }
            }
            reader.close()
        }
        return cars
    }
}