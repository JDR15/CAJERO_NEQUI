package com.example.cajero_nequi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.paulaacs15.nequi.R
import java.util.Random
class Dash_Board_ : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        val retirar_ = findViewById<Button>(R.id.Retirar)
        val recargar = findViewById<Button>(R.id.Recargar)
        val consignar_=findViewById<Button>(R.id.Consignar)
        val saldo_=findViewById<TextView>(R.id.ValorSaldo)
        val telefonoConsignacion_=findViewById<EditText>(R.id.telefono)
        val valorConsignacion_=findViewById<EditText>(R.id.valorCon)
        val valorRecarga_=findViewById<EditText>(R.id.valorReca)
        val valorRetiro_=findViewById<EditText>(R.id.ValorReti)
        val numeroCod=findViewById<TextView>(R.id.numeroCo)
        retirar_.setOnClickListener{
            if (valorRecarga_.text.toString().toInt() >saldo_.text.toString().toInt()){
                Toast.makeText(this, "¡No puede ser mayor al saldo!", Toast.LENGTH_LONG).show()
            }
            else{
                val instanciaRandom= Random()
                var Codigo=instanciaRandom.nextInt(2222)
                numeroCod.text=Codigo.toString()
            }
        }
        recargar.setOnClickListener {
            var saldo2=saldo_.text.toString().toInt()+valorRecarga_.text.toString().toInt()
            saldo_.text=saldo2.toString()
        }
        consignar_.setOnClickListener {
            if (valorConsignacion_.text.toString().toInt() >saldo_.text.toString().toInt()){
                Toast.makeText(this, "¡No puede ser mayor al saldo!", Toast.LENGTH_LONG).show()
            }
            else{
                var saldo2=saldo_.text.toString().toInt()-valorConsignacion_.text.toString().toInt()
                Toast.makeText(this, "Se consigno ${valorConsignacion_.text.toString()}, al numero ${telefonoConsignacion_.text.toString()}", Toast.LENGTH_LONG).show()
                saldo_.text=saldo2.toString()
            }
        }
    }
}
