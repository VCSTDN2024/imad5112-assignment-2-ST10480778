package com.example.quizgame

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class ReviewScreen : AppCompatActivity() {
    private lateinit var exitBtn:Button
    private lateinit var reviewButton: Button
    private lateinit var restartButton: Button
    private lateinit var commentTextView: TextView
    private lateinit var scoreTextView: TextView
    private lateinit var reviewTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_screen)

        reviewTxt = findViewById(R.id.reviewTxt)
        reviewButton = findViewById(R.id.reviewButton)
        restartButton = findViewById(R.id.restartButton)
        exitBtn = findViewById(R.id.exitBtn)
        commentTextView = findViewById(R.id.commentTextView)
        scoreTextView = findViewById(R.id.scoreTextView)

        val score = intent.getIntExtra("score",0)
        scoreTextView.text= "your score: $score/5"
        scoreTextView.textSize = 25f
        scoreTextView.setTypeface(null, Typeface.BOLD)
        val feedback= if (score >3){
            "well done!"
        } else {
            "Please keep practicing"
        }
        commentTextView.text = feedback
        commentTextView.textSize=25f
        commentTextView.setTypeface(null,Typeface.BOLD)

        restartButton.setOnClickListener {
            val intent = Intent(this,QuestionScreen1::class.java)
            startActivity(intent)
        }
        val questions = intent.getStringExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")
        reviewButton.setOnClickListener {
            if (questions != null && answers != null) {
                val reviewText = StringBuilder()

                for (i in questions.indices) {

                    reviewText.append("${i + 1}: ${questions[i]}\n")
                    reviewText.append("Answer: $answers\n\n")
                }
                reviewTxt.text = reviewTxt.toString()
            } else {
                reviewTxt.text = "Something went wrong. No questions or answers found."

            }
        }
        exitBtn.setOnClickListener {
            finish()
            exitProcess(0)
        }

    }
}
