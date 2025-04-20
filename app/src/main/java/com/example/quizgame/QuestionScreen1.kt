package com.example.quizgame

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuestionScreen1 : AppCompatActivity() {
    private lateinit var posBtn: Button
    private lateinit var negBtn: Button
    private lateinit var nextBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question_screen1)
        
        posBtn=findViewById(R.id.posBtn)
        negBtn=findViewById(R.id.negBtn)
        nextBtn=findViewById(R.id.nextBtn)
        val category= arrayOf(
            "General Knowledge"
        )
        val questions= arrayOf(
            "It takes a sloth two weeks to digest a meal?",
            "An ant can lift 1000 times its body weight?",
            "The goat is the natural animal of Scotland?",
            "South Africa has three capital?",
            "Mount Everest is the tallest mountain in the world?"
        )
        val answers = booleanArrayOf(true,false,false,true,true)


        posBtn.setOnClickListener {

        }
        negBtn.setOnClickListener {

        }

        nextBtn.setOnClickListener {

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}