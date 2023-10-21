package com.condex.pmdmpractica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.condex.pmdmpractica1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BTNResult.setOnClickListener{
            setListener()
        }
    }

    private fun setListener(){

        val peso: TextView = findViewById(R.id.TextPeso)
        val altura: TextView = findViewById(R.id.TextoAltura)

        var rbhombre:RadioButton?=null
        var rbmujer:RadioButton?=null

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
            val imcComparar = imcFormateado.toDouble()

            rbhombre=findViewById(R.id.RBHombre)
            rbmujer=findViewById(R.id.RBMujer)

            if(rbhombre?.isChecked==true){
                if(imcComparar < 18.5){
                    binding.TxtInfo.text=getString(R.string.Peso_inferior_al_normal)
                }else{
                    if(imcComparar < 24.9){
                        binding.TxtInfo.text=getString(R.string.Nomral)
                    }else{
                        if(imcComparar < 29.9){
                            binding.TxtInfo.text=getString(R.string.Sobrepeso)
                        }else{
                            if(imcComparar > 30)binding.TxtInfo.text=getString(R.string.Obesidad)
                        }
                    }
                }
            }
            if(rbmujer?.isChecked==true){
                if(imcComparar < 18.5){
                    binding.TxtInfo.text=getString(R.string.Peso_inferior_al_normal)
                }else{
                    if(imcComparar < 23.9){
                        binding.TxtInfo.text=getString(R.string.Nomral)
                    }else{
                        if(imcComparar < 28.9){
                            binding.TxtInfo.text=getString(R.string.Sobrepeso)
                        }else{
                            if(imcComparar > 29)binding.TxtInfo.text=getString(R.string.Obesidad)
                        }
                    }
                }
            }
        }
    }
}


