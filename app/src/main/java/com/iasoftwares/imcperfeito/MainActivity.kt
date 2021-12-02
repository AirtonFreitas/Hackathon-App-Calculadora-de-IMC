package com.iasoftwares.imcperfeito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils.isEmpty
import android.widget.TextView
import android.widget.Toast
import com.iasoftwares.imcperfeito.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMainCalcular.setOnClickListener {
            var peso = binding.editMainPeso.text.toString()
            var altura = binding.editMainAltura.text.toString()

            if (peso.isEmpty()) {
                binding.editMainPeso.error = "Campo vazio!"
                binding.editMainPeso.requestFocus()
            } else if (altura.isEmpty()) {
                binding.editMainAltura.error = "Campo vazio!"
                binding.editMainAltura.requestFocus()
            } else {
                var pesoF: Float = peso.toFloat()
                var alturaF: Float = altura.toFloat()

                var resultado: Float = pesoF / (alturaF * alturaF)
                binding.txvResultadoImc.text = resultado.toString()
                binding.txvResultadoImc.visibility = TextView.VISIBLE
                binding.txvSeuResultado.visibility = TextView.VISIBLE
                binding.txvComplemento.visibility = TextView.VISIBLE
                Handler().postDelayed({
                    binding.txvResultadoImc.visibility = TextView.INVISIBLE
                    binding.txvSeuResultado.visibility = TextView.INVISIBLE
                    binding.txvComplemento.visibility = TextView.INVISIBLE
                }, 10000)

            }
        }
    }
}
