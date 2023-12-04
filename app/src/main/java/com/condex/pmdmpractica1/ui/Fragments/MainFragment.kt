package com.condex.pmdmpractica1.ui.Fragments

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.condex.pmdmpractica1.R
import com.condex.pmdmpractica1.databinding.FragmentMainFragmnetBinding
import java.io.IOException
import java.io.OutputStreamWriter
import java.time.Month
import java.time.format.TextStyle
import java.util.*

class MainFragment : Fragment() {

    private var _binding: FragmentMainFragmnetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainFragmnetBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.BTNResult.setOnClickListener {
            setListener()
        }

        // Cambios necesarios para la navegación y otras interacciones

        return view
    }

    private fun setListener() {
        // Similar a tu método setListener en la Activity
        // Recuerda que ahora debes usar 'requireContext()' en lugar de 'this' para obtener el contexto

        val peso: TextView = binding.TextPeso
        val altura: TextView = binding.TextoAltura



        val ishombre = binding.RBHombre.isChecked


        //el if es para verificar que se ha introducido el peso y la altura

        if (peso.text.isEmpty() || altura.text.isEmpty()) {
            Toast.makeText(requireContext(), "Los campos de Peso y Altura no deben estar vacios para realizar el calculo", Toast.LENGTH_LONG).show()
        }
        else{

            var numpeso: Double = peso.text.toString().toDouble()
            var numaltura: Double = altura.text.toString().toDouble()

            //Calculo para pasarlo a metros
            val alturacm =numaltura/100
            //calcular IMC
            var imc = numpeso / (alturacm*alturacm)
            val imcFormateado = String.format("%.2f", imc)

            //mando el resultado al TxtResultado para que lo imprima
            binding.TxtResultado.text= imcFormateado

            //Logica para que en el TXT de abajo aparezca el indicador fisico
            if(ishombre==true){
                if(imc < 18.5){
                    binding.TxtInfo.text=getString(R.string.Peso_inferior_al_normal)
                }else{
                    if(imc < 24.9){
                        binding.TxtInfo.text=getString(R.string.Nomral)
                    }else{
                        if(imc < 29.9){
                            binding.TxtInfo.text=getString(R.string.Sobrepeso)
                        }else{
                            if(imc > 30)binding.TxtInfo.text=getString(R.string.Obesidad)
                        }
                    }
                }
            }else{
                if(imc < 18.5){
                    binding.TxtInfo.text=getString(R.string.Peso_inferior_al_normal)
                }else{
                    if(imc < 23.9){
                        binding.TxtInfo.text=getString(R.string.Nomral)
                    }else{
                        if(imc < 28.9){
                            binding.TxtInfo.text=getString(R.string.Sobrepeso)
                        }else{
                            if(imc > 29)binding.TxtInfo.text=getString(R.string.Obesidad)
                        }
                    }
                }
            }
            // Obtener la fecha actual


            val hoy = Calendar.getInstance()
            val numeroMes = hoy.get(Calendar.MONTH) + 1

            val dia="${hoy.get(Calendar.DAY_OF_MONTH)}"
            val mes= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Month.of(numeroMes).getDisplayName(TextStyle.FULL, Locale("es", "ES"))
            } else {
                TODO("VERSION.SDK_INT < O")
            }
            val anyo="${hoy.get(Calendar.YEAR)}"
            val fechaActual = "${hoy.get(Calendar.DAY_OF_MONTH)}" + "/${hoy.get(Calendar.MONTH) + 1}" + "/${hoy.get(Calendar.YEAR)}"

            // Llamar a la función para guardar el IMC
            guardarIMC(dia,mes,anyo, if (ishombre) "Hombre" else "Mujer", imcFormateado, binding.TxtInfo.text.toString())
        }
    }

    private fun guardarIMC(dia: String, mes: String, anyo: String, genero: String, imc: String, descripcion: String) {
        val archivo = "registro_imc.txt"
        val line = "$dia;$mes;$anyo;$genero;$imc;$descripcion\n"
        try {
            // Utilizar requireContext() para obtener el contexto en un Fragment
            val outputStreamWriter = OutputStreamWriter(requireContext().openFileOutput(archivo, Context.MODE_APPEND))
            outputStreamWriter.write(line)
            outputStreamWriter.close()
            Toast.makeText(requireContext(), "IMC registrado con éxito", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            Toast.makeText(requireContext(), "Error al guardar el IMC", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}