package com.iasoftwares.imcperfeito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iasoftwares.imcperfeito.databinding.ActivityUnderWeightBinding

class UnderWeightActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUnderWeightBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnderWeightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVoltar.setOnClickListener {
            var mIntent = Intent(this, MainActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }
}