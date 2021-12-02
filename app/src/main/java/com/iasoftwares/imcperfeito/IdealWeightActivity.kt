package com.iasoftwares.imcperfeito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iasoftwares.imcperfeito.databinding.ActivityIdealWeightBinding

class IdealWeightActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIdealWeightBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdealWeightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVoltar.setOnClickListener {
            var mIntent = Intent(this, MainActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }
}