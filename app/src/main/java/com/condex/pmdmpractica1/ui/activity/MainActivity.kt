package com.condex.pmdmpractica1.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.condex.pmdmpractica1.R
import com.condex.pmdmpractica1.databinding.ActivityMainBinding
import java.io.IOException
import java.io.OutputStreamWriter
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BTNResult.setOnClickListener{
            setListener()
        }

        binding.BTNHistorial.setOnClickListener{
            val intent= Intent(this, MainActivity2::class.java)
            startActivityForResult(intent,1234)
        }
    }


    private fun setListener(){

        val peso: TextView = findViewById(R.id.TextPeso)
        val altura: TextView = findViewById(R.id.TextoAltura)

        //var rbhombre:RadioButton?=null
        //var rbmujer:RadioButton?=null

        val ishombre = binding.RBHombre.isChecked


        //el if es para verificar que se ha introducido el peso y la altura

        if(peso.length() == 0 || altura.length() == 0){
            Toast.makeText(this,"Los campos de Peso y Altura no deben estar vacios para realizar el calculo",Toast.LENGTH_LONG).show();
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
            val fechaActual =
                "${hoy.get(Calendar.DAY_OF_MONTH)}" + "/${hoy.get(Calendar.MONTH) + 1}" + "/${hoy.get(Calendar.YEAR)}"

            // Llamar a la función para guardar el IMC
            guardarIMC(fechaActual, if (ishombre) "Hombre" else "Mujer", imc, binding.TxtInfo.text.toString())




        }

    }
    private fun guardarIMC(fecha: String, genero: String, imc: Double, descripcion: String) {
        val archivo = "registro_imc.txt"
        val line = "$fecha;$genero;$imc;$descripcion\n"
        try {
            val outputStreamWriter = OutputStreamWriter(openFileOutput(archivo, Context.MODE_APPEND))
            outputStreamWriter.write(line)
            outputStreamWriter.close()
            Toast.makeText(this, "IMC registrado con éxito", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            Toast.makeText(this, "Error al guardar el IMC", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }
}


