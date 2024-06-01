package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.tictactoe.databinding.FragmentResultDialogBinding

class ResultDialog : DialogFragment() {

    private var _binding: FragmentResultDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val message = arguments?.getString("message")
        binding.messageText.text = message

        binding.restartBtn.setOnClickListener {
            (activity as? MainActivity)?.restartMatch()
            dismiss()
        }
        binding.homeBtn.setOnClickListener {
                val intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_HOME)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(message: String): ResultDialog {
            val dialog = ResultDialog()
            val args = Bundle()
            args.putString("message", message)
            dialog.arguments = args
            return dialog
        }
    }
}


//package com.example.tictactoe
//
//import android.app.Dialog
//import android.content.Context
//import android.os.Bundle
//import android.widget.Button
//import android.widget.TextView
//
//class ResultDialog(
//    context: Context,
//    private val message: String,
//    private val mainActivity: MainActivity
//) :
//    Dialog(context) {
//    override fun onCreate(savedInstanceState: Bundle) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_result_dialog)
//        val messageText = findViewById<TextView>(R.id.messageText)
//        val startAgainButton = findViewById<Button>(R.id.startAgainButton)
//        messageText.text = message
//        startAgainButton.setOnClickListener {
//            mainActivity.restartMatch()
//            dismiss()
//        }
//    }
//}
