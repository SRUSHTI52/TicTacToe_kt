package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import android.R.id
import androidx.appcompat.app.AppCompatActivity

lateinit var playerOne : EditText
lateinit var playerTwo : EditText
lateinit var startGameButton : Button

class AddPlayers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_players)
         playerOne = findViewById(R.id.playerOne)
         playerTwo = findViewById(R.id.playerTwo)
         startGameButton = findViewById(R.id.startGameButton)
        startGameButton.setOnClickListener {
            val  PlayerOneName = playerOne.text.toString()
            val PlayerTwoName = playerTwo.text.toString()

            if (PlayerOneName.isEmpty() || PlayerTwoName.isEmpty()) {
                Toast.makeText(this@AddPlayers, "Please enter player name", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(
                    this@AddPlayers,
                    MainActivity::class.java
                )
                intent.putExtra("playerOne", PlayerOneName)
                intent.putExtra("playerTwo", PlayerTwoName)
                startActivity(intent)
            }
        }
    }
    }
