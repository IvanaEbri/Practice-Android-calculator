package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var ingresoDatos: EditText //lateint la propiedad no es necesario que tenga un dato: Inicialización posterior
    private var operando: Double = 0.0
    private var operador: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ingresoDatos = findViewById(R.id.ingresoDatos)
    }

    fun clickEnBotonOperando(view: View) {
        val boton = view as Button //Conversión de tipo view a Buttom
        val textoActual = ingresoDatos.text.toString()
        val nuevoTexto = textoActual + boton.text.toString()
        ingresoDatos.setText(nuevoTexto)
    }


    fun clickEnBotonOperador(view: View){
        val botonOperador = view as Button //Conversion de tipos
        operador = botonOperador.text.toString()
        if (operando == 0.0 ){
            operando = ingresoDatos.text.toString().toDouble()
        }
        ingresoDatos.text.clear()

    }

    fun clickEnBotonComa(){
        val textoActual = ingresoDatos.text.toString()
        val nuevoTexto: String = if (textoActual.contains(".")){
            textoActual
        } else if (textoActual != "") {
            "$textoActual."
        } else {
            "0."
        }
        ingresoDatos.setText(nuevoTexto)

    }

    fun clickEnBotonIgual(){
        val operando2 = ingresoDatos.text.toString().toDouble()
        var resultado = 0.0

        when(operador) {
            "+" -> resultado = operando + operando2
            "-" -> resultado = operando - operando2
            "*" -> resultado = operando * operando2
            "/" -> resultado = operando / operando2
        }
        ingresoDatos.setText(resultado.toString())

    }


    fun clickEnBotonBorrar(){
        ingresoDatos.text.clear()
        operando = 0.0
        operador = null

    }

    fun clickEnBotonDel(){
        val valorActual = ingresoDatos.text.toString()
        val nuevoTexto = valorActual.dropLast(1)
        ingresoDatos.setText(nuevoTexto)
    }
}