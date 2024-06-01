package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val iHome = Intent(this@SplashScreen, AddPlayers::class.java)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(iHome)
            finish()
        }, 3000)
    }
}
