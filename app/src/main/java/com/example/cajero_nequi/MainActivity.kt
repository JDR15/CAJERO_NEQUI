package com.example.cajero_nequi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.paulaacs15.nequi.R

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun verificarCadena(cadena: String): Boolean {
            for (indice in cadena) {
                if (indice.isDigit()) {
                    return false
                }
            }
            return true
        }

        val telefono_ = findViewById<EditText>(R.id.telefono)
        val contrasena_ = findViewById<EditText>(R.id.Contrasena)
        val mensaje_= findViewById<TextView>(R.id.mensaje)
        val boton_ = findViewById<Button>(R.id.Ingresar)
        val verificar_ = verificarCadena(contrasena_.text.toString())
        boton_.setOnClickListener {
            if (!verificar_) {
                val nuevoTexto = "La contraseña debe ser numerica "
                mensaje_.text=nuevoTexto
            }
            else if (contrasena_.text.toString().length < 4 || contrasena_.text.toString().length > 4){
                val nuevoTexto = "La contraseña debe de ser de 4 digitos"
                mensaje_.text=nuevoTexto
            }
            else {
                if (telefono_.text.toString().equals("1234") && contrasena_.text.toString().equals("1111")){
                    // Redirige a otra actividad si la cadena no contiene números
                    val intent = Intent(this, Dash_Board_::class.java)
                    startActivity(intent)
                }
                else{
                    val nuevoTexto = "Datos de acceso incorrectos"
                    mensaje_.text=nuevoTexto
                }
            }
        }
    }
}