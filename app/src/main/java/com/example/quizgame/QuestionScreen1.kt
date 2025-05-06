package com.example.quizgame

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

/*
*
*
*
* */
class QuestionScreen1 : AppCompatActivity() {
    private lateinit var posBtn: Button
    private lateinit var negBtn: Button
    private lateinit var nextBtn: Button
    private lateinit var displayText:TextView
    private lateinit var ResultsText:TextView

   companion object {

        val questions = arrayOf(
            "The first indigenous people to populate south africa were san people?",
            "Nelson mandela is south africa's current president?",
            "South africa's national flower is the sunflower?",
            "South Africa has three capital?",
            "Mount Everest is the tallest mountain in the world?",
        )
        val answers = booleanArrayOf(true, false, false, true, true)
    }



    private var currentQuestionIndex =0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question_screen1)

        posBtn=findViewById(R.id.posBtn)
        negBtn=findViewById(R.id.negBtn)
        nextBtn=findViewById(R.id.nextBtn)
        displayText=findViewById(R.id.displayText)
        ResultsText=findViewById(R.id.ResultsText)

        displayQuestion()

        posBtn.setOnClickListener {
            matchAnswerToQuestion(true)
        }
        negBtn.setOnClickListener {
          matchAnswerToQuestion(false)
        }

        nextBtn.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex <questions.size){
                displayQuestion()
                ResultsText.text = ""
                posBtn.isEnabled = true
                negBtn.isEnabled=true
            }else{
                val intent = Intent(this,Results::class.java)
                intent.putExtra("score",score)
                startActivity(intent)
                finish()
            }
        }
        nextBtn.isEnabled = false
    }
    private fun displayQuestion() {

        displayText.text = questions[currentQuestionIndex]
    }


    private fun matchAnswerToQuestion(userAnswer:Boolean){
        val correctAnswer = answers[currentQuestionIndex]

       if (userAnswer == correctAnswer){
            ResultsText.text="well done! your answer is correct "
            ResultsText.setTextColor(Color.GREEN)
            score++
        } else{
            ResultsText.text="incorrect"
            ResultsText.setTextColor(Color.RED)
        }
       posBtn.isEnabled = false
       negBtn.isEnabled = false
       nextBtn.isEnabled = true
    }

}