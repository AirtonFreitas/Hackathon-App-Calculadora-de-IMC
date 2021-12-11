package com.iasoftwares.imcperfeito


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import com.iasoftwares.imcperfeito.databinding.ActivityMainBinding

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
                exibirComponentes()
                ativarComplemento(resultado)
            }
        }
    }

    private fun exibirComponentes() {

        binding.txvResultadoImc.visibility = TextView.VISIBLE
        binding.txvSeuResultado.visibility = TextView.VISIBLE
        binding.txvComplemento.visibility = TextView.VISIBLE
        binding.btnSaibaMais.visibility = TextView.VISIBLE
        Handler().postDelayed({
            binding.txvResultadoImc.visibility = TextView.INVISIBLE
            binding.txvSeuResultado.visibility = TextView.INVISIBLE
            binding.txvComplemento.visibility = TextView.INVISIBLE
            binding.btnSaibaMais.visibility = TextView.INVISIBLE
        }, 13000)
    }

    private fun ativarComplemento(resultado: Float) {
        if (resultado <= 18.5) {
            binding.txvComplemento.setText(R.string.baixo_peso)
            binding.btnSaibaMais.setOnClickListener {
                var mIntent = Intent(this, UnderWeightActivity::class.java)
                startActivity(mIntent)
            }
        } else if (resultado > 18.5 && resultado <= 24.9) {
            binding.txvComplemento.setText(R.string.peso_ideal)
            binding.btnSaibaMais.setOnClickListener {
                var mIntent = Intent(this, IdealWeightActivity::class.java)
                startActivity(mIntent)
            }
        } else if (resultado > 24.9 && resultado <= 30) {
            binding.txvComplemento.setText(R.string.sobrepeso)
            binding.btnSaibaMais.setOnClickListener {
                var mIntent = Intent(this, OverweightActivity::class.java)
                startActivity(mIntent)
            }
        } else if (resultado > 30) {
            binding.txvComplemento.setText(R.string.obesidade)
            binding.btnSaibaMais.setOnClickListener {
                var mIntent = Intent(this, ObesityActivity::class.java)
                startActivity(mIntent)
            }
        }
    }
}
