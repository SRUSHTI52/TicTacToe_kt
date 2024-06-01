package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val combinationList: MutableList<IntArray> = ArrayList()
    private var boxPositions = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0) // 9 zero
    private var playerTurn = 1
    private var totalSelectedBoxes = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        combinationList.add(intArrayOf(0, 1, 2))
        combinationList.add(intArrayOf(3, 4, 5))
        combinationList.add(intArrayOf(6, 7, 8))
        combinationList.add(intArrayOf(0, 3, 6))
        combinationList.add(intArrayOf(1, 4, 7))
        combinationList.add(intArrayOf(2, 5, 8))
        combinationList.add(intArrayOf(2, 4, 6))
        combinationList.add(intArrayOf(0, 4, 8))

        val getPlayerOneName = intent.getStringExtra("playerOne")
        val getPlayerTwoName = intent.getStringExtra("playerTwo")
        binding.playerOneName.text = getPlayerOneName
        binding.playerTwoName.text = getPlayerTwoName

        binding.image1.setOnClickListener { view ->
            if (isBoxSelectable(0)) {
                performAction(view as ImageView, 0)
            }
        }
        binding.image2.setOnClickListener { view ->
            if (isBoxSelectable(1)) {
                performAction(view as ImageView, 1)
            }
        }
        binding.image3.setOnClickListener { view ->
            if (isBoxSelectable(2)) {
                performAction(view as ImageView, 2)
            }
        }
        binding.image4.setOnClickListener { view ->
            if (isBoxSelectable(3)) {
                performAction(view as ImageView, 3)
            }
        }
        binding.image5.setOnClickListener { view ->
            if (isBoxSelectable(4)) {
                performAction(view as ImageView, 4)
            }
        }
        binding.image6.setOnClickListener { view ->
            if (isBoxSelectable(5)) {
                performAction(view as ImageView, 5)
            }
        }
        binding.image7.setOnClickListener { view ->
            if (isBoxSelectable(6)) {
                performAction(view as ImageView, 6)
            }
        }
        binding.image8.setOnClickListener { view ->
            if (isBoxSelectable(7)) {
                performAction(view as ImageView, 7)
            }
        }
        binding.image9.setOnClickListener { view ->
            if (isBoxSelectable(8)) {
                performAction(view as ImageView, 8)
            }
        }

        binding.home.setOnClickListener{
            val intent = Intent(
                this@MainActivity,
                AddPlayers::class.java
            )
            startActivity(intent)
        }

        binding.restart.setOnClickListener{
            restartMatch()
        }
    }


    public fun performAction(imageView: ImageView, selectedBoxPosition: Int) {
        boxPositions[selectedBoxPosition] = playerTurn
        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.x_white)
            if (checkResults()) {
                showResultDialog("${binding.playerOneName.text} is a Winner!")
            } else if (totalSelectedBoxes == 9) {
                showResultDialog("Match Draw")
            } else {
                changePlayerTurn(2)
                totalSelectedBoxes++
            }
        } else {
            imageView.setImageResource(R.drawable.o_white)
            if (checkResults()) {
                showResultDialog("${binding.playerTwoName.text} is a Winner!")
            } else if (totalSelectedBoxes == 9) {
                showResultDialog("Match Draw")
            } else {
                changePlayerTurn(1)
                totalSelectedBoxes++
            }
        }
    }


    private fun showResultDialog(message: String) {
        val resultDialog = ResultDialog.newInstance(message)
        resultDialog.isCancelable = false
        resultDialog.show(supportFragmentManager, "ResultDialog")
    }

    private fun changePlayerTurn(currentPlayerTurn: Int) {
        playerTurn = currentPlayerTurn
        if (playerTurn == 1) {
            //binding.playerOneLayout.setBackgroundResource(R.drawable.black_border)
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_box_white)
            binding.playerTwoLayout.setBackgroundResource(R.drawable.lav_box_without_border)
            binding.playerOneName.setTextColor(resources.getColor(R.color.lavender,null))
            binding.playerTwoName.setTextColor(resources.getColor(R.color.white, null))
        } else {
            //binding.playerTwoLayout.setBackgroundResource(R.drawable.black_border)
            binding.playerOneLayout.setBackgroundResource(R.drawable.lav_box_without_border)
            binding.playerTwoLayout.setBackgroundResource(R.drawable.white_box_white)
            binding.playerOneName.setTextColor(resources.getColor(R.color.white, null))
            binding.playerTwoName.setTextColor(resources.getColor(R.color.lavender, null))
        }
    }

    private fun checkResults(): Boolean {
        for (combination in combinationList) {
            if ((boxPositions[combination[0]] == playerTurn) &&
                (boxPositions[combination[1]] == playerTurn) &&
                (boxPositions[combination[2]] == playerTurn)) {
                return true
            }
        }
        return false
    }

    private fun isBoxSelectable(boxPosition: Int): Boolean {
        return boxPositions[boxPosition] == 0
    }

    fun restartMatch() {
        boxPositions = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0) // 9 zero
        playerTurn = 1
        totalSelectedBoxes = 1
        binding.image1.setImageResource(R.drawable.lav_box_without_border)
        binding.image2.setImageResource(R.drawable.lav_box_without_border)
        binding.image3.setImageResource(R.drawable.lav_box_without_border)
        binding.image4.setImageResource(R.drawable.lav_box_without_border)
        binding.image5.setImageResource(R.drawable.lav_box_without_border)
        binding.image6.setImageResource(R.drawable.lav_box_without_border)
        binding.image7.setImageResource(R.drawable.lav_box_without_border)
        binding.image8.setImageResource(R.drawable.lav_box_without_border)
        binding.image9.setImageResource(R.drawable.lav_box_without_border)

    }
}
