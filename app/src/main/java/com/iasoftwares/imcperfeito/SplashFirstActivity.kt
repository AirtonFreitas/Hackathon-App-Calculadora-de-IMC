package com.iasoftwares.imcperfeito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.iasoftwares.imcperfeito.databinding.ActivityFirstBinding


class SplashFirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            val mIntent = Intent(this, SplashSecondActivity::class.java)
            startActivity(mIntent)
        },3000)

    }
}