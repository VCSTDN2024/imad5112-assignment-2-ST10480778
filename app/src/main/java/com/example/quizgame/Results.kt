package com.example.quizgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Results : AppCompatActivity() {

    private lateinit var reviewButton: Button
    private lateinit var restartButton: Button
    private lateinit var commentTextView: TextView
    private lateinit var scoreTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_results)

        reviewButton = findViewById(R.id.reviewButton)
        restartButton = findViewById(R.id.restartButton)
        commentTextView = findViewById(R.id.commentTextView)
        scoreTextView = findViewById(R.id.scoreTextView)

        val questions = intent.getStringExtra("questions")
        val answers = intent.getBooleanArrayExtra("questions")

        val score = intent.getIntExtra("score",0)
        scoreTextView.text= "your score: $score/5"

        val feedback= if (score >3){
            "well done!"
        } else {
            "Please keep practicing"
        }
        commentTextView.text = feedback

        restartButton.setOnClickListener {

        }
        reviewButton.setOnClickListener {
            val intent = Intent(this,ReviewScreen::class.java)
            intent.putExtra("questions",QuestionScreen1.questions)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}