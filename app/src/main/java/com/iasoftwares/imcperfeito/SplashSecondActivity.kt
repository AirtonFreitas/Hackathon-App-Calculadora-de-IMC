package com.iasoftwares.imcperfeito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.iasoftwares.imcperfeito.databinding.ActivitySecondBinding

class SplashSecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            val mIntent = Intent(this, SplashThirdActivity::class.java)
            startActivity(mIntent)
        },3000)
    }
}