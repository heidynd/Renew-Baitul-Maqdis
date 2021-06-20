package com.example.renewbaitulmaqdis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class BmSplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bm_splash_screen)

        val bmImage: ImageView = findViewById(R.id.bmSplash)
        val bmText: TextView = findViewById(R.id.textBM)
        val slideAnimation = AnimationUtils.loadAnimation(this,R.anim.slide_bm)
        bmImage.startAnimation(slideAnimation)
        bmText.startAnimation(slideAnimation)

        Handler().postDelayed({
            startActivity(Intent(this@BmSplashScreen, MainActivity::class.java))
            finish()
        }, 3000)
    }
}